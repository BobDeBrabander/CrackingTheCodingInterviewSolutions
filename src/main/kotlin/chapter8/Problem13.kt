package chapter8

import kotlin.math.max

object Problem13 {

    data class Box(
        val width: Int,
        val height: Int,
        val depth: Int
    ) : Comparable<Box>{
        fun strictlySmallerThan(other: Box): Boolean {
            return this.depth < other.depth && this.height < other.height && this.width < other.width
        }

        override fun compareTo(other: Box): Int {
            return other.depth.compareTo(this.depth) + other.height.compareTo(this.height) + other.width.compareTo(this.width)
        }
    }

    fun largestStack(boxes: List<Box>) : Int{
        val sortedBoxes = boxes.sorted()
        return largestStack(-1, sortedBoxes, 0)
    }

    private fun largestStack(lastPick: Int, boxes: List<Box>, currentHeight: Int) : Int{
        var max = currentHeight
        for (i in lastPick+1 until boxes.size){
            if (lastPick == -1 || boxes[i].strictlySmallerThan(boxes[lastPick])){
                max = max(max, largestStack(i, boxes, currentHeight+boxes[i].height))
            }
        }
        return max
    }
}