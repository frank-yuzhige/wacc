package utils

class LabelNameTable {
    private val nameMap = hashMapOf<String, Int>()

    fun getName(prefix: String): String {
        val id = getId(prefix)
        return "${prefix}_$id"
    }

    fun getId(prefix: String): Int {
        val prevId = nameMap[prefix]
        if (prevId != null) {
            nameMap[prefix] = prevId + 1
            return prevId + 1
        }
        nameMap[prefix] = 0
        return 0
    }
}