package chapter17

import kotlin.math.max

object Problem8 {

    data class Tower(val height: Int, val width: Int) : Comparable<Tower> {
        override fun compareTo(other: Tower): Int {
            //Descending sorting
            return if (other.height == this.height) {
                other.width.compareTo(this.width)
            } else {
                other.height.compareTo(this.height)
            }
        }

    }

    //List of towers is pairs of height x width
    fun circusTower(towers: List<Tower>): Int {
        val sortedTowers = towers.sorted()
        var tallest = 0
        val memo = mutableMapOf<Int, Int>()
        for (i in sortedTowers.indices) {
            tallest = max(tallest, tallestTower(sortedTowers, i, memo))
        }
        return tallest
    }

    private fun tallestTower(towers: List<Tower>, baseIndex: Int, memo: MutableMap<Int, Int>): Int {
        if (memo[baseIndex] != null) return memo[baseIndex]!!
        var tallest = 1
        for (i in baseIndex + 1 until towers.size) {
            if (towers[i].height < towers[baseIndex].height && towers[i].width < towers[baseIndex].width) {
                tallest = max(tallest, 1 + tallestTower(towers, i, memo))
            }
        }
        memo[baseIndex] = tallest
        return memo[baseIndex]!!
    }
}