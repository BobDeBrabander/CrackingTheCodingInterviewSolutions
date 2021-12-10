package chapter16

import kotlin.math.max

object Problem17 {

    fun contiguousSeq(list: List<Int>): Int {
        var maxSum = Int.MIN_VALUE
        var curSum = 0
        list.forEach {
            curSum += it
            maxSum = max(maxSum, curSum)
            if (curSum < 0) curSum = 0
        }
        return maxSum
    }
}