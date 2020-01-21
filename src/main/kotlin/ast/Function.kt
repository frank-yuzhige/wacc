package ast

class Function(
        val returnType : Type,
        val name : String,
        val args : List<Parameter>,
        val body : Statements
) {
    
}