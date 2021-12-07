package chapter8

import kotlin.math.max
import kotlin.math.min

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

    //If values are not distinct you can't do better than checking almost all elements, we can skip some and recursively
    //search the left and right side
    fun findMagicIndexWithDuplicates(list: List<Int>) : Int{
        return findMagicIndexWithDuplicates(list, 0, list.size-1)
    }

    private fun findMagicIndexWithDuplicates(list: List<Int>, start: Int, end: Int) : Int{
        if (start > end) return -1
        val mid = (start + end)/2
        if (list[mid] == mid) return mid

        val leftIndex = min(mid-1, list[mid])
        val left = findMagicIndexWithDuplicates(list, start, leftIndex)
        if (left >= 0) return left

        val rightIndex = max(mid+1, list[mid])
        val right = findMagicIndexWithDuplicates(list, rightIndex, end)
        if (right >= 0) return right

        return -1
    }
}