package ast

data class Function(
        val returnType : Type,
        val name : String,
        val args : List<Parameter>,
        val body : Statements
) {
    
}