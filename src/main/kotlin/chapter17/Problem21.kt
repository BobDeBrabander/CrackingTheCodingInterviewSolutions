package chapter17

import kotlin.math.min

object Problem21 {

    fun volumeOfHistogram(hist: List<Int>): Int {
        if (hist.size < 3) return 0
        val nextTallestBar = MutableList(hist.size) { -1 }
        nextTallestBar[hist.size - 2] = hist.size - 1
        for (i in hist.size - 3 downTo 0) {
            if (hist[i+1] > hist[nextTallestBar[i+1]]) nextTallestBar[i] = i+1 else nextTallestBar[i] = nextTallestBar[i+1]
        }
        var startIndex = -1
        for (i in hist.indices) {
            if (hist[i] > 0) {
                startIndex = i
                break
            }
        }
        return if (startIndex == -1) 0
        else volumeBetweenBarsFrom(startIndex, hist, nextTallestBar)
    }

    private fun volumeBetweenBarsFrom(startIndex: Int, hist: List<Int>, tallestAfter: List<Int>): Int {
        if (startIndex >= hist.size) return 0
        if (tallestAfter[startIndex] == -1 || hist[tallestAfter[startIndex]] == 0) return 0
        if (hist[tallestAfter[startIndex]] <= hist[startIndex]){
            return calculateSumBetweenBars(startIndex, tallestAfter[startIndex], hist)+ volumeBetweenBarsFrom(tallestAfter[startIndex], hist, tallestAfter)
        }
        var endIndex = -1
        var highestEnd = 0
        var curIndex = startIndex + 1
        while (curIndex <= hist.lastIndex) {
            if (hist[curIndex] > highestEnd) {
                highestEnd = hist[curIndex]
                endIndex = curIndex
            }
            if (highestEnd >= hist[startIndex]) {
                return calculateSumBetweenBars(startIndex, endIndex, hist) +
                        volumeBetweenBarsFrom(endIndex, hist, tallestAfter)
            }
            curIndex++
        }
        return 0
    }

    private fun calculateSumBetweenBars(startIndex: Int, endIndex: Int, hist: List<Int>): Int {
        val height = min(hist[startIndex], hist[endIndex])
        var sum = 0
        for (i in startIndex + 1 until endIndex) {
            if (hist[i] < height) sum += (height - hist[i])
        }
        return sum
    }
}