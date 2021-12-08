package chapter10

object Problem9 {

    //For an MxN matrix (M rows, N columns) this algorithm would perform with O(M log(N))
    fun findElement(matrix: List<List<Int>>, element: Int) : Pair<Int, Int>? {
        var startRow = 0
        while (startRow < matrix.size && matrix[startRow][matrix[startRow].size-1] < element) startRow++

        var endRow = 0
        while (endRow+1 < matrix.size && matrix[endRow+1][0] <= element) endRow++

        for (i in startRow..endRow){
            val found = binarySearch(matrix[i], element, 0, matrix[i].size-1)
            if (found != -1) return i to found
        }
        return null
    }

    fun binarySearch(list: List<Int>, element: Int, start: Int, end: Int): Int {
        if (end < start) return -1
        val mid = (start + end) / 2
        return when {
            element == list[mid] -> mid
            element < list[mid] -> binarySearch(list, element, start, mid - 1)
            else -> binarySearch(list, element, mid + 1, end)
        }
    }
}