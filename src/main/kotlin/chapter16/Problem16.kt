package chapter16

object Problem16 {

    fun subSort(list: List<Int>): Pair<Int, Int> {
        val sortedList = list.sorted()
        var start = 0
        while (start < list.size && list[start] == sortedList[start]) {
            start++
        }
        if (start == list.size) return 0 to 0

        var end = list.size - 1
        while (end > 0 && list[end] == sortedList[end]) {
            end--
        }
        return start to end
    }
}