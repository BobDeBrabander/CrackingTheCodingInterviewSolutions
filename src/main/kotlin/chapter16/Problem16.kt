package chapter16

object Problem16 {

    fun subSort(list: List<Int>): Pair<Int, Int>? {
        val endOfStart = endOfStartSequence(list)
        if (endOfStart == list.size - 1) return null //already sorted

        val startOfEnd = startOfEndSequence(list)
        var maxIndex = endOfStart
        var minIndex = startOfEnd
        for (i in endOfStart + 1 until startOfEnd) {
            if (list[i] < list[minIndex]) minIndex = i
            if (list[i] > list[maxIndex]) maxIndex = i
        }

        return shrinkLeft(list, minIndex, endOfStart) to shrinkRight(list, maxIndex, startOfEnd)
    }

    private fun endOfStartSequence(list: List<Int>): Int {
        for (i in 1 until list.size) {
            if (list[i] < list[i - 1]) {
                return i - 1
            }
        }
        return list.size - 1
    }

    private fun startOfEndSequence(list: List<Int>): Int {
        for (i in list.size - 2 downTo 0) {
            if (list[i] > list[i + 1]) {
                return i + 1
            }
        }
        return 0
    }

    private fun shrinkLeft(list: List<Int>, minIndex: Int, start: Int): Int {
        val comp = list[minIndex]
        for (i in start - 1 downTo 0) {
            if (list[i] <= comp) return i + 1
        }
        return 0
    }

    private fun shrinkRight(list: List<Int>, maxIndex: Int, end: Int): Int {
        val comp = list[maxIndex]
        for (i in end + 1 until list.size) {
            if (list[i] >= comp) return i - 1
        }
        return list.size - 1
    }
}