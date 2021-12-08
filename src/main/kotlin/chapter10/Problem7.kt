package chapter10

object Problem7 {

    fun integerNotContainedIn(list: List<Int>) : Int {
        var leastCommonEnding = ""
        var significantDigit = 0
        var counters = mutableMapOf(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0, 7 to 0, 8 to 0, 9 to 0)
        repeat(10) {
            list.forEach {
                //This could be done without the toString part with some funky math but this is purely for illustration
                val stringNum = it.toString()
                if (stringNum.endsWith(leastCommonEnding)) {
                    val digit = stringNum.getOrElse(stringNum.length - 1 - significantDigit) { '0' }.digitToInt()
                    counters[digit] = counters[digit]!! + 1
                }
            }
            val leastOccurringDigit = counters.minByOrNull { it.value }
            leastCommonEnding = "${leastOccurringDigit?.key}$leastCommonEnding"
            if (leastOccurringDigit?.value == 0) {
                return leastCommonEnding.toInt()
            }
            significantDigit++
            counters = mutableMapOf(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0, 7 to 0, 8 to 0, 9 to 0)
        }
        return -1
    }
}