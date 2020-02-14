package codegen.arm

import codegen.arm.Operand.Label

class StringConst(val label: Label, val content: String) {
    companion object {
        fun fromCodegenCollections(singletons: Map<String, Label>, commons: MutableList<Pair<String, Label>>): Collection<StringConst> {
            return singletons.map { (content, label) -> StringConst(label, content) } +
                    commons.map { StringConst(it.second, it.first) }
        }
    }

    override fun toString(): String {
        return "${label.name}:\n    .word ${content.length}\n    .ascii \"$content\\0\""
    }

}