package chapter10

object Problem3 {

    //list of distinct element is originally sorted ascending, then rotated an unknown amount of times
    //return index of element if it's there or -1 if it's not there
    fun searchInRotatedArray(list: List<Int>, element: Int): Int {
        return if (list[list.size - 1] > list[0]) {
            binarySearch(list, element, 0, 0, list.size - 1)
        } else {
            val rotations = howManyRotations(list, 0, list.size - 1)
            binarySearch(list, element, rotations, 0, list.size - 1)
        }
    }

    fun howManyRotations(list: List<Int>, start: Int, end: Int): Int {
        if (start == end) return start
        if (start + 1 == end) {
            return if (list[start] < list[end]) start
            else end
        }
        val mid = (start + end) / 2
        return if (list[start] < list[mid]) {
            howManyRotations(list, mid, end)
        } else {
            howManyRotations(list, start, mid)
        }
    }

    fun binarySearch(list: List<Int>, element: Int, rotations: Int, start: Int, end: Int): Int {
        if (end < start) return -1
        val mid = (start + end) / 2
        return when {
            element == list[(mid + rotations) % list.size] -> (mid + rotations) % list.size
            element < list[(mid + rotations) % list.size] -> binarySearch(list, element, rotations, start, mid - 1)
            else -> binarySearch(list, element, rotations, mid + 1, end)
        }
    }
}