package chapter17

import kotlin.math.max

object Problem16 {

    fun masseuse(list: List<Int>) : Int {
        val memo = HashMap<Int, Int>()
        return masseuse(list, 0, memo)
    }

    fun masseuse(list: List<Int>, index: Int, memo: HashMap<Int, Int>) : Int {
        if (index >= list.size) return 0
        if (memo.containsKey(index)) return memo[index]!!
        val pick = list[index] + masseuse(list, index+2, memo)
        val dontPick = masseuse(list, index+1, memo)
        memo[index] = max(pick, dontPick)
        return memo[index]!!
    }

    fun masseuseLessSpace(list: List<Int>): Int {
        var oneAway = 0
        var twoAway = 0
        for (i in list.lastIndex downTo 0){
            val bestWith = list[i] + twoAway
            val bestWithout = oneAway
            val current = max(bestWith, bestWithout)

            twoAway = oneAway
            oneAway = current
        }
        return oneAway
    }
}