package codegen

import ast.Function
import ast.Type

data class GroundFunction (val function: Function, val groundType: Type.FuncType) {
    companion object {
        infix fun Function.groundBy(funcType: Type.FuncType): GroundFunction {
            return GroundFunction(this, funcType)
        }
    }
}