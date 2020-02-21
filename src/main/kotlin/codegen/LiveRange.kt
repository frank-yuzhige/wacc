package codegen

import codegen.arm.Operand.Register.Reg

class LiveRange(firstDef: Int) {
    val defs = mutableListOf<Int>()
    val uses = mutableListOf<Int>()

    init {
        defs += firstDef
    }

    fun lastUsage(): Int = uses.last()

    fun nextUsage(now: Int): Int = uses.first { it > now }

    fun firstDef(): Int = defs.first()

    fun isUsedAt(index: Int) = (uses + defs).contains(index)

    fun isNotUsedDuring(other: LiveRange): Boolean {
        return (defs + uses).all { it < other.firstDef() || it > other.lastUsage() }
    }

    fun mergeToPairs(): List<Pair<String, Int>> {
        val pairs = mutableListOf<Pair<String, Int>>()
        pairs += defs.map { "def" to it }
        pairs += uses.map { "use" to it }
        return pairs.sortedWith(compareBy { pair: Pair<String, Int> -> pair.second } then compareBy { it.first })
    }

    override fun toString(): String {
        return mergeToPairs().joinToString(", ")
    }

}

typealias LiveRangeMap = Map<Reg, LiveRange>

fun LiveRangeMap.findVirtualToPush(
        waitingVirtual: Reg,
        virtualToRealMap: MutableMap<Reg, Reg>,
        pushedVirtuals: MutableSet<Reg>
): Reg {
    val waitingRegRange = this[waitingVirtual]
            ?: throw IllegalArgumentException("Given register $waitingVirtual is not in the live range map")
    virtualToRealMap.keys.filterNot { it in pushedVirtuals }.forEach { candidate ->
        val liveRange = this.getValue(candidate)
        if (liveRange.isNotUsedDuring(waitingRegRange)) {
            return candidate
        }
    }
    throw IllegalArgumentException("Unable to find such register which is not in use for $waitingVirtual")
}

fun LiveRangeMap.dump() {
    forEach { (reg, liveRange) ->
        println("$reg:, $liveRange")
    }
}