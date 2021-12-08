package chapter10

object Problem5 {

    //Assumption: element can not be ""
    fun sparseSearch(list: List<String>, element: String): Int {
        return sparseSearch(list, element, 0, list.size - 1)
    }

    private fun sparseSearch(list: List<String>, element: String, start: Int, end: Int): Int {
        if (end < start) return -1
        var mid = (start + end) / 2
        var left = mid-1
        var right = mid+1
        while (true){
            if (left < start && right > end) return -1
            else if (right <= end && list[right] != "" ){
                mid = right
                break
            }
            else if (left >= start && list[left] != "") {
                mid = left
                break
            }
            left--
            right++
        }
        return when {
            list[mid] == element -> mid //list[mid] is element
            list[mid] < element -> sparseSearch(list, element, mid + 1, end) //list[mid] comes before element
            else -> sparseSearch(list, element, start, mid - 1) //list[mid] comes after element
        }

    }
}