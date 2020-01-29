package semantics

import ast.Expression
import ast.Expression.*
import ast.Type
import ast.Type.*
import ast.Type.BaseTypeKind.*
import com.sun.org.apache.bcel.internal.generic.RET
import utils.SymbolTable


class TypeChecker(val symbolTable: SymbolTable, vararg expected: Type) {
    fun check(expr: Expression) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    infix fun Type.check(actual: Type): Boolean {
        if(this is BaseType && this.kind == ANY) {
            return true
        }
        return when(this) {
            is BaseType -> this.kind == ANY || this == actual
            is ArrayType -> when (actual) {
                is ArrayType -> this.type check actual.type
                else -> false
            }
            is PairType -> when (actual) {
                is PairType -> this.firstElemType check actual.firstElemType
                        && this.secondElemType check actual.secondElemType
                else -> false
            }
            is FuncType -> when (actual) {
                is FuncType -> this.retType check actual.retType
                        && this.paramTypes.size == actual.paramTypes.size
                        && this.paramTypes
                        .zip(actual.paramTypes) { a, b -> a check b}
                        .reduce {a, b -> a && b}
                else -> false
            }
        }
    }

    fun Type.checkExpr(expr: Expression): Boolean {
        return when (expr) {
            is IntLit, is BoolLit, is CharLit, is StringLit -> this check expr.getType(symbolTable)
            is BinExpr -> expr.op.getOperandTypes(this)
                    .contains(expr.left.getType(symbolTable) to expr.right.getType(symbolTable))
            else -> false
        }
    }

}
