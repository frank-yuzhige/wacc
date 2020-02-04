package utils

class LabelNameTable {
    private val nameMap = hashMapOf<String, Int>()

    fun getName(prefix: String): String {
        if (nameMap.containsKey(prefix)) {
            nameMap[prefix] = nameMap.getValue(prefix) + 1
        } else {
            nameMap += prefix to 0
        }
        return "${prefix}_${nameMap[prefix]}"
    }
}