package ast

enum class BaseTypeKind(val symbol: String) {
    INT("int"),
    BOOL("bool"),
    CHAR("char"),
    STRING("string"),
    ANY("?")
}
