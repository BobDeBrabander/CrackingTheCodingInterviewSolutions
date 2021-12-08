package chapter10

object Problem4 {

    class Listy(private val list: List<Int>) {
        fun elementAt(i: Int): Int {
            return if (i in list.indices) list[i]
            else -1
        }
    }

    fun listySortedSearch(listy: Listy, element: Int) : Int{
        return binarySearch(listy, element, 0, 1 shl 30)
    }

    private fun binarySearch(listy: Listy, element: Int, start: Int, end: Int): Int {
        if (end < start) return -1
        val mid = (start + end) / 2
        val elementFound = listy.elementAt(mid)
        return when {
            -1 == elementFound -> binarySearch(listy, element, start, mid-1)
            element == elementFound -> mid
            element < elementFound -> binarySearch(listy, element, start, mid - 1)
            else -> binarySearch(listy, element, mid + 1, end)
        }
    }
}