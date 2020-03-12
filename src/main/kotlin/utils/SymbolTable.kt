package utils

import ast.*
import ast.Expression.Identifier
import ast.Function
import ast.Type.*
import ast.Type.Companion.arrayTypeOf
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.stringType
import exceptions.SemanticException
import exceptions.SemanticException.*
import utils.SymbolTable.TypeAttributes.Companion.arrayAttributes
import utils.SymbolTable.TypeAttributes.Companion.baseTypeAttributes
import utils.SymbolTable.TypeAttributes.Companion.pairAttributes
import java.util.*
import kotlin.IllegalArgumentException

class SymbolTable {
    private val scopeStack: Deque<MutableMap<String, VarAttributes>> = ArrayDeque()
    private val scopeIdStack: Deque<Int> = ArrayDeque()
    private val traitDefs: MutableMap<Trait, TraitAttributes> = mutableMapOf()
    val typedefs: MutableMap<String, TypeAttributes> = mutableMapOf()
    val unionIdMap: MutableMap<String, Int> = mutableMapOf()
    val functions: MutableMap<String, FuncAttributes> = hashMapOf()
    val collect: MutableMap<VarWithSID, VarAttributes> = hashMapOf()
    val scopeDefs: MutableMap<Int, Set<String>> = hashMapOf()
    private var scopeIdGen = 0

    init {
        typedefs += "array" to arrayAttributes()
        typedefs += "pair" to pairAttributes()
        typedefs += "int" to baseTypeAttributes(intType(), "Eq", "Ord", "Show", "Num", "Enum", "Read")
        typedefs += "bool" to baseTypeAttributes(boolType(), "Eq", "Ord", "Show", "Enum")
        typedefs += "char" to baseTypeAttributes(charType(), "Eq", "Ord", "Show", "Num", "Enum", "Read")
        typedefs += "string" to baseTypeAttributes(stringType(), "Eq", "Show")
        traitDefs += Trait("Eq") to TraitAttributes("A", emptySet(), emptyList(), mutableMapOf())
        traitDefs += Trait("Ord") to TraitAttributes("A", setOf(Trait("Eq")), emptyList(), mutableMapOf())
        traitDefs += Trait("Malloc") to TraitAttributes("A", emptySet(), emptyList(), mutableMapOf())
        traitDefs += Trait("Show") to TraitAttributes("A", emptySet(), emptyList(), mutableMapOf())
        traitDefs += Trait("Num") to TraitAttributes("A", setOf(Trait("Ord")), emptyList(), mutableMapOf())
        traitDefs += Trait("Enum") to TraitAttributes("A", setOf(Trait("Ord")), emptyList(), mutableMapOf())
    }

    fun defineVar(type: Type, identNode: Identifier, isConst: Boolean): VarAttributes? {
        val name = identNode.name
        val currScope = this.scopeStack.first()
        val entry = currScope[name]
        if (entry != null) {
            return entry
        }
        val sid = getCurrScopeId()
        identNode.scopeId = sid
        currScope[name] = VarAttributes(type, isConst , getCurrScopeId(), identNode.startIndex)
        return null
    }

    fun defineFunc(func: Function) {
        val entry = functions[func.name]
        if (entry != null) {
            throw MultipleFuncDefException(func.name, entry.type, entry.index)
        }
        functions[func.name] = FuncAttributes(func.getFuncType(), func.args, null, func.startIndex)
    }

    fun defineType(def: NewTypeDef) {
        when (def) {
            is NewTypeDef.StructTypeDef -> {
                val entry = functions[def.name()]
                if (entry != null) {
                    throw MultipleFuncDefException(def.name(), entry.type, entry.index)
                }
                if (def.members.isEmpty()) {
                    throw TypeDefEmptyBodyException(def.type)
                }
                val defaultMallocMap = mutableMapOf(
                        Trait("Malloc") to (1..def.type.generics.size).map { emptySet<Trait>() }
                )
                typedefs[def.type.name] = TypeAttributes(def.type, false, defaultMallocMap, setOf(def.name()), def.startIndex)
                functions[def.name()] = FuncAttributes(def.constructorFuncType(), def.members, null, def.startIndex)
            }

            is NewTypeDef.UnionTypeDef -> {
                val entry = typedefs[def.type.name]
                if (entry != null) {
                    throw MultipleTypeDefException(def.type.name, entry.index)
                }
                if (def.memberMap.isEmpty()) {
                    throw TypeDefEmptyBodyException(def.type)
                }
                val defaultMallocMap = mutableMapOf(
                        Trait("Malloc") to (1..def.type.generics.size).map { emptySet<Trait>() }
                )
                typedefs[def.type.name] = TypeAttributes(def.type, true, defaultMallocMap, def.memberMap.keys, def.startIndex)
                var unionId = 0
                def.memberMap.forEach { (constructor, params) ->
                    val fentry = functions[constructor]
                    if (fentry != null) {
                        throw MultipleFuncDefException(constructor, fentry.type, fentry.index)
                    }
                    val funType = FuncType(def.type, params.map { it.first })
                    functions[constructor] = FuncAttributes(funType, params, null, def.startIndex)
                    unionIdMap[constructor] = unionId++
                }
            }
        }
    }

    fun defineTrait(traitDef: TraitDef) {
        val trait = Trait(traitDef.traitName)
        val entry = traitDefs[trait]
        if (entry != null) {
            throw MultipleTraitDefException(traitDef.traitName, traitDef.startIndex)
        }
        for (tc in traitDef.typeConstraints) {
            if(tc.typeVar != traitDef.traitVar) {
                throw IrrelevantTraitDependencyVarException(traitDef.traitVar, tc)
            }
            if (tc.trait.traitName == traitDef.traitName) {
                throw TraitDependOnSelfException(traitDef.traitName)
            }
        }
        // add trait def entry
        traitDefs[trait] = TraitAttributes(
                traitDef.traitVar,
                traitDef.typeConstraints.map { it.trait }.toSet(),
                traitDef.requiredFuncs
        )
        // Add required functions
        traitDef.requiredFuncs.forEach { header ->
            val funcType = header.getFuncType()
            if (!funcType.containsTypeVar(traitDef.traitVar)) {
                throw IrrelevantTraitFuncException(trait.traitName, header.name, traitDef.traitVar, funcType)
            }
            functions[header.name] = FuncAttributes(funcType, header.args, trait, header.startIndex)
        }
    }

    fun implementTrait(instance: TraitInstance) {
        when(instance.targetType) {
            is NewType, is BaseType -> {
                val bindedType = instance.targetType.bindConstraints(instance.typeConstraints)
                val traitEntry = traitDefs[instance.trait]
                        ?: throw UndefinedTraitException(instance.trait.traitName)
                // check if all dependencies are implemented.
                for (dependency in traitEntry.dependencies) {
                    if (!isInstance(bindedType, dependency)) {
                        throw TypeNotInstanceOfADependentTraitException(
                                instance.targetType,
                                instance.trait.traitName,
                                dependency.traitName
                        )
                    }
                }
                // check if required are all defined.
                val sub = mapOf((traitEntry.traitVar to false) to instance.targetType)
                val required = traitEntry.requiredFuncs
                        .map { it.name to it.getFuncType().substitutes(sub) as FuncType }
                        .toMap().toMutableMap()
                val definedFuncNames = mutableSetOf<String>()
                instance.functions.forEach { func ->
                    val funcHeader = func.extractHeader()
                    if (funcHeader.name !in required) {
                        throw NotATraitRequiredFuncException(funcHeader.name, instance.trait.traitName)
                    }
                    if (funcHeader.name in definedFuncNames) {
                        throw MultipleFuncDefException(funcHeader.name, funcHeader.getFuncType(), 1 to 1)
                    }
                    val requiredType = required.getValue(funcHeader.name)
                    if (requiredType != funcHeader.getFuncType()) {
                        throw TraitRequiredFuncTypeError(instance.trait.traitName, funcHeader.name, requiredType, funcHeader.getFuncType())
                    }
                    definedFuncNames += funcHeader.name

                }
                if (instance.targetType is NewType) {
                    val typeEntry = typedefs[instance.targetType.name]
                            ?: throw UndefinedTypeException(instance.targetType.name)
                    val genericTraitsList = instance.targetType.generics.map { tvar ->
                        when{
                            tvar !is TypeVar -> throw InstanceWithGroundGenericTypeException(instance.targetType)
                            else -> {
                                instance.typeConstraints
                                        .filter { it.typeVar == tvar.name }
                                        .map { it.trait }
                                        .toSet()
                            }
                        }
                    }
                    typeEntry.traitDependencies[instance.trait] = genericTraitsList
                } else { // base type
                    val typeEntry = typedefs.getValue(instance.targetType.toString())
                    typeEntry.traitDependencies[instance.trait] = emptyList()
                }

                for (impl in instance.functions) {
                    if (impl.name in traitEntry.implementations) {
                        traitEntry.implementations[impl.name]!! += impl
                    } else {
                        traitEntry.implementations[impl.name] = mutableListOf(impl)
                    }

                }
            }
            else -> throw ImplToTraitForTypeUnsupoortedException(instance.targetType)
        }
    }

    fun pushScope() {
        scopeStack.addFirst(hashMapOf())
        scopeIdStack.addFirst(scopeIdGen++)
    }

    fun popScope(): List<String>? {
        val prevId = scopeIdStack.pollFirst()
        return scopeStack.pollFirst()
                ?.also { prev -> collectPrevScope(prevId, prev) }
                ?.filter { (_, attrs) -> attrs.occurrences == 1 }
                ?.map { (ident, attr) ->
                    "Unused variable $ident at ${attr.index}: variable defined but its value is never used"
                }
    }

    fun lookupVar(ident: Identifier, isWrite: Boolean): VarAttributes? {
        val attr = scopeStack
                .mapNotNull { it[ident.name] }
                .firstOrNull()
        if (attr != null) {
            if (attr.isConst && isWrite) {
                throw SemanticException.WriteToConstVarException(ident.name)
            }
            return attr.addOccurrence().also { ident.scopeId = it.scopeId }
        }
        return null
    }

    fun lookupFunc(ident: String): FuncAttributes? = functions[ident]?.addOccurrence()

    fun lookupType(type: NewType): TypeAttributes? = typedefs[type.name]

    fun findConstructorType(constructor: String): NewType? = lookupFunc(constructor)?.type?.retType as? NewType

    fun dumpTable(): String = "${getFuncTable()}\n${getVarTable()}"

    fun dump() {
        println(getVarTable())
        println(getFuncTable())
    }

    fun getVarTable(): String {
        val tp = TablePrinter("variable", "scope id", "type", "defined at", "ref count")
                .markIntColumn(1, 4)
                .sortBy(0, 1)
        collect.map { (pair, attr) ->
            tp.addColumn(pair.first, pair.second, attr.type, attr.index, attr.occurrences)
        }

        return tp.print()
    }

    private fun getFuncTable(): String {
        val tp = TablePrinter("function", "type", "defined at", "ref count")
                .sortBy(0, 2)
        functions.map { (name, attr) ->
            tp.addColumn(name, attr.type, attr.index, attr.occurrences)
        }
        return tp.print()
    }

    fun isInstance(type: Type, trait: Trait): Boolean {
        return when(type) {
            is BaseType -> {
                val entry = typedefs[type.toString()]!!
                trait in entry.traitDependencies.keys
            }
            is NewType -> {
                val entry = lookupType(type)?:throw UndefinedTypeException(type.name)
                trait in entry.traitDependencies.keys && type.generics.withIndex().all { (i, type) ->
                    val currRequiredTraits = entry.traitDependencies.getValue(trait)[i]
                    currRequiredTraits.all { isInstance(type, it) }
                }
            }
            is TypeVar -> trait in getAllDependencies(type.traits)
            is FuncType -> false
            is ErrorType -> true
        }
    }

    fun getAllDependencies(traits: Iterable<Trait>): Set<Trait> {
        val set = mutableSetOf<Trait>()
        fun dfs(trait: Trait) {
            if(trait !in set) {
                set += trait
                traitDefs.getValue(trait).dependencies.map { dfs(it) }
            }
        }
        traits.map { dfs(it) }
        return set
    }

    /* Find the correct trait func def for the given ground type. */
    fun findTraitFuncDef(fName: String, groundType: FuncType): Function {
        val fEntry = functions[fName] ?: throw UndefinedFuncException(fName)
        if(fEntry.trait != null) {
            val tEntry = traitDefs[fEntry.trait]
                    ?: throw UndefinedTraitException(fEntry.trait.traitName)
            for (impl in tEntry.implementations.getValue(fName)) {
                try {
                    groundType.inferFrom(impl.getFuncType(), this)
                } catch (sme: SemanticException) {
                    continue
                }
                return impl
            }
        }
        throw IllegalArgumentException("$fName is not a trait function")
    }

    fun getTypeMemberType(type: Type, member: String): Type {
        return when {
            type !is NewType -> throw TypeMismatchException(type, type)
            type.name !in typedefs -> throw UndefinedTypeException(type.name)
            typedefs.getValue(type.name).isUnion -> throw NotAStructTypeException(type)
            else -> {
                val typeEntry = typedefs.getValue(type.name)
                val sub = type.findUnifier(typeEntry.typeWhenDef)
                functions[type.name]?.members?.find { it.second.name == member }?.first?.substitutes(sub)
                        ?: throw UndefinedFuncException(type.toString())
            }
        }
    }

    private fun getCurrScopeId(): Int = scopeIdStack.peekFirst()

    private fun collectPrevScope(prevId: Int, prev: MutableMap<String, VarAttributes>) {
        prev.forEach { (ident, attr) ->
            collect[ident to prevId] = attr
        }
        scopeDefs[prevId] = prev.keys
    }

    data class FuncAttributes(
            val type: FuncType,
            val members: List<Parameter>,
            val trait: Trait?,
            val index: Index,
            var occurrences: Int = 1
    ) {
        fun addOccurrence(): FuncAttributes = this.also { occurrences++ }
    }
    data class VarAttributes(
            val type: Type,
            val isConst: Boolean,
            val scopeId: Int,
            val index: Index,
            var occurrences: Int = 1
    ) {
        fun addOccurrence(): VarAttributes = this.also { occurrences++ }
    }
    data class TypeAttributes(
            val typeWhenDef: Type,
            val isUnion: Boolean,
            val traitDependencies: MutableMap<Trait, List<Set<Trait>>>,
            val constructors: Set<String>,
            val index: Index,
            var occurrences: Int = 1
    ) {
        companion object {
            fun arrayAttributes(): TypeAttributes {
                val impls = mutableMapOf(
                        Trait("Eq") to listOf(setOf(Trait("Eq"))),
                        Trait("Show") to listOf(setOf(Trait("Show"))),
                        Trait("Malloc") to listOf(emptySet())
                )
                return TypeAttributes(arrayTypeOf(TypeVar("A")),false, impls, emptySet(), -1 to -1)
            }
            fun pairAttributes(): TypeAttributes {
                val impls = mutableMapOf(
                        Trait("Eq") to listOf(setOf(Trait("Eq")), setOf(Trait("Eq"))),
                        Trait("Malloc") to listOf(emptySet(), emptySet())
                )
                return TypeAttributes(arrayTypeOf(TypeVar("A")),false, impls, emptySet(), -1 to -1)
            }
            fun baseTypeAttributes(type: Type, vararg traits: String): TypeAttributes {
                val impls = traits.map { Trait(it) to emptyList<Set<Trait>>() }.toMap().toMutableMap()
                return TypeAttributes(type, false, impls, emptySet(), -1 to -1)
            }
        }
        fun addOccurrence(): TypeAttributes = this.also { occurrences++ }
    }
    data class TraitAttributes(
            val traitVar: String,
            val dependencies: Set<Trait>,
            val requiredFuncs: List<FunctionHeader>,
            val implementations: MutableMap<String, MutableList<Function>> = mutableMapOf()
    )

}

