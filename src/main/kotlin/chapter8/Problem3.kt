package chapter8

object Problem3 {

    //Assumption values are distinct
    fun findMagicIndex(list: List<Int>) : Int{
        return findMagicIndex(list, 0, list.size-1)
    }

    private fun findMagicIndex(list: List<Int>, start: Int, end: Int) : Int{
        if (start > end) return -1
        val mid = (start + end)/2
        return when {
            list[mid] == mid -> mid
            mid > list[mid] -> {
                //Everything on the left will have list[i] < mid since values are distinct
                findMagicIndex(list, mid+1, end)
            }
            else -> {
                //mid < list[mid]
                //Everything on the right will have list[i] > i since values are distinct
                findMagicIndex(list, start, mid-1)
            }
        }
    }

    //If values are not distinct you can't do better than checking all elements
    //Example 0 1 3 3 3 4 6 6 7 8
    //This list has 0, 1, 3, and 6 has magic indexes
}