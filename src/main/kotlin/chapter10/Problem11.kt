package chapter10

import kotlin.math.max

object Problem11 {

    fun peaksAndValleys(list: List<Int>): List<Int> {
        val mutableList = list.toMutableList()
        for (i in 1 until mutableList.size step 2) {
            val aVal = mutableList.getOrElse(i - 1) { Int.MIN_VALUE }
            val bVal = mutableList.getOrElse(i) { Int.MIN_VALUE }
            val cVal = mutableList.getOrElse(i + 1) { Int.MIN_VALUE }
            val max = max(aVal, max(bVal, cVal))
            val maxIndex = when(max){
                aVal -> i-1
                bVal -> i
                else -> i+1
            }

            if (i != maxIndex) {
                val temp = mutableList[i]
                mutableList[i] = mutableList[maxIndex]
                mutableList[maxIndex] = temp
            }
        }
        return mutableList.toList()
    }

}