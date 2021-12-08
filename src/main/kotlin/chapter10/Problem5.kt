package chapter10

object Problem5 {

    //Assumption: element can not be ""
    fun sparseSearch(list: List<String>, element: String): Int {
        return sparseSearch(list, element, 0, list.size - 1)
    }

    private fun sparseSearch(list: List<String>, element: String, start: Int, end: Int): Int {
        if (end < start) return -1
        var mid = (start + end) / 2
        while (list[mid] == "" && mid >= start) mid-- //search for the first non-empty string left
        if (mid < start) {
            //we didn't find a non-empty string left, so now search right
            mid = (start + end) / 2
            while (list[mid] == "" && mid <= end) mid++
        }
        if (mid > end) return -1 //we searched right and also didn't find a non-empty string

        return when {
            list[mid] == element -> mid //list[mid] is element
            list[mid] < element -> sparseSearch(list, element, mid + 1, end) //list[mid] comes before element
            else -> sparseSearch(list, element, start, mid - 1) //list[mid] comes after element
        }

    }
}