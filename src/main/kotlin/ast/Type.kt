package ast

import ast.Expression.PairElemFunction
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Type.BaseTypeKind.*

sealed class Type {

    enum class BaseTypeKind(val symbol: String) {
        INT("int"),
        BOOL("bool"),
        CHAR("char"),
        STRING("string"),
        ANY("?")
    }

    companion object {
        fun anyArrayType(): ArrayType = ArrayType(anyType())
        fun anyPairType(): PairType =
                PairType(BaseType(ANY), BaseType(ANY))

        fun anyType(): Type = TypeVar("A")

        fun intType(): BaseType = BaseType(INT)
        fun boolType(): BaseType = BaseType(BOOL)
        fun charType(): BaseType = BaseType(CHAR)
        fun stringType(): BaseType = BaseType(STRING)
        fun rangeTypeOf(type: Type) = NewType("Range", type)
    }

    data class BaseType(val kind: BaseTypeKind) : Type() {
        override fun toString(): String = kind.symbol
    }

    data class ArrayType(val type: Type) : Type() {
        override fun toString(): String = "$type[]"
        override fun bindConstraints(constraints: List<TypeConstraint>): Type {
            return ArrayType(type.bindConstraints(constraints))
        }

        override fun substitutes(substitutions: Map<Pair<String, Boolean>, Type>): Type {
            return ArrayType(type.substitutes(substitutions))
        }

        override fun isGround(): Boolean = type.isGround()

        override fun reified(constraints: List<TypeConstraint>): Type = ArrayType(type.reified(constraints))
    }

    data class PairType(val firstElemType: Type, val secondElemType: Type) : Type() {
        override fun toString(): String =
                if (firstElemType != BaseType(ANY) || secondElemType != BaseType(ANY)) {
                    "pair($firstElemType, $secondElemType)"
                } else {
                    "pair"
                }

        override fun normalize(): Type {
            val t1 = when(firstElemType) { is PairType -> anyPairType(); else -> firstElemType }
            val t2 = when(secondElemType) { is PairType -> anyPairType(); else -> secondElemType }
            return PairType(t1, t2)
        }
    }

    data class NewType(val name: String, val generics: List<Type> = emptyList()): Type() {
        constructor(name: String, vararg generics: Type): this(name, generics.asList())
        override fun toString(): String {
            return "${name}${if(generics.isEmpty())"" else "<${generics.joinToString(", ")}>"}"
        }

        override fun bindConstraints(constraints: List<TypeConstraint>): Type {
            return NewType(name, generics.map { it.bindConstraints(constraints) })
        }

        override fun substitutes(substitutions: Map<Pair<String, Boolean>, Type>): Type {
            return NewType(name, generics.map { it.substitutes(substitutions) })
        }

        override fun isGround(): Boolean = generics.all { it.isGround() }
        override fun reified(constraints: List<TypeConstraint>): Type {
            return NewType(name, generics.map { it.reified(constraints) })
        }
    }

    data class TypeVar(val name: String, val traits: List<Trait>, val isReified: Boolean = false): Type() {
        constructor(name: String, vararg traits: Trait): this(name, traits.toList())

        override fun toString(): String = if(isReified) "@_$name" else "_$name"
        override fun reified(constraints: List<TypeConstraint>): Type =
                TypeVar(name, constraints.filter { it.typeVar == name }.map { it.trait },true)
        override fun bindConstraints(constraints: List<TypeConstraint>): Type {
            return TypeVar(name, traits + constraints.filter { it.typeVar == name }.map { it.trait }, isReified)
        }
        override fun substitutes(substitutions: Map<Pair<String, Boolean>, Type>): Type {
            return substitutions[name to isReified]?:this
        }
        override fun equals(other: Any?): Boolean {
            return other is TypeVar && other.name == name && other.isReified == isReified
        }
        override fun hashCode(): Int {
            var result = name.hashCode()
            result = 31 * result + traits.hashCode()
            result = 31 * result + isReified.hashCode()
            return result
        }

        override fun isGround(): Boolean = isReified
    }

    data class FuncType(val retType: Type,
                        val paramTypes: List<Type>) : Type() {
        companion object {
            fun binOpOf(type: Type): FuncType = FuncType(type, listOf(type, type))
            fun binCheckOf(type: Type): FuncType = FuncType(boolType(), listOf(type, type))
        }

        override fun toString(): String {
            val constraints = if (collectConstraints().isNotEmpty()) "[${collectConstraints().joinToString(", ")}] => " else ""
            return "$constraints(${paramTypes.joinToString(", ") { it.toString() }}) -> $retType"
        }

        override fun reified(constraints: List<TypeConstraint>): Type = FuncType(
                retType.reified(constraints),
                paramTypes.map { it.reified(constraints) }
        )

        override fun bindConstraints(constraints: List<TypeConstraint>): Type {
            return FuncType(retType.bindConstraints(constraints), paramTypes.map { it.bindConstraints(constraints) })
        }

        override fun substitutes(substitutions: Map<Pair<String, Boolean>, Type>): Type {
            val params = paramTypes.map { it.substitutes(substitutions) }
            return FuncType(retType.substitutes(substitutions), params)
        }

        fun collectConstraints(): List<TypeConstraint> {
            val collect = mutableMapOf<String, List<Trait>>()
            (paramTypes + retType).filterIsInstance<TypeVar>().forEach { tvar ->
                if (tvar.name in collect && collect[tvar.name]!!.toHashSet() != tvar.traits.toHashSet() ) {
                    throw IllegalArgumentException("inconsistent type vars!")
                } else {
                    collect[tvar.name] = tvar.traits
                }
            }
            return collect.flatMap { (name, traits) -> traits.map { TypeConstraint(it, name) } }
        }

        override fun isGround(): Boolean = (paramTypes + retType).all { it.isGround() }
    }

    open fun normalize(): Type = this

    open fun reified(constraints: List<TypeConstraint>): Type = this

    open fun bindConstraints(constraints: List<TypeConstraint>): Type = this

    open fun substitutes(substitutions: Map<Pair<String, Boolean>, Type>): Type = this

    open fun isGround(): Boolean = true

    fun unwrapArrayType(): Type? = when (this) {
        is ArrayType -> type
        else -> null
    }

    fun unwrapArrayType(count: Int): Type? {
        var t: Type? = this
        for (i in 0 until count) {
            t = t?.unwrapArrayType()
            if (t == null) {
                return null
            }
        }
        return t
    }
    fun unwrapPairType(elem: PairElemFunction): Type? = when (this) {
        is PairType -> when (elem) {
            FST -> this.firstElemType
            SND -> this.secondElemType
        }
        else -> null
    }
}

