package chapter8

import kotlin.math.max

object Problem13 {

    data class Box(
        val width: Int,
        val height: Int,
        val depth: Int
    ) : Comparable<Box> {
        fun strictlySmallerThan(other: Box): Boolean {
            return this.depth < other.depth && this.height < other.height && this.width < other.width
        }

        override fun compareTo(other: Box): Int {
            return other.depth.compareTo(this.depth) + other.height.compareTo(this.height) + other.width.compareTo(this.width)
        }
    }

    fun largestStack(boxes: List<Box>): Int {
        val sortedBoxes = boxes.sorted()
        return largestStack(sortedBoxes, -1, HashMap())
    }

    private fun largestStack(boxes: List<Box>, lastPick: Int, stackMap: HashMap<Int, Int>): Int {
        if (stackMap.containsKey(lastPick)) return stackMap[lastPick]!!
        var maxHeight = 0
        for (i in lastPick + 1 until boxes.size) {
            if (lastPick == -1 || boxes[i].strictlySmallerThan(boxes[lastPick])) {
                val height = largestStack(boxes, i, stackMap)
                maxHeight = max(maxHeight, height)
            }
        }
        val lastBoxHeight = if (lastPick == -1) 0 else boxes[lastPick].height
        maxHeight += lastBoxHeight
        if (lastPick != -1) stackMap[lastPick] = maxHeight
        return maxHeight
    }
}