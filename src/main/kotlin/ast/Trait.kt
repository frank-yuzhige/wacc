package ast

data class Trait(val traitName: String) {
    override fun toString(): String {
        return traitName
    }
}