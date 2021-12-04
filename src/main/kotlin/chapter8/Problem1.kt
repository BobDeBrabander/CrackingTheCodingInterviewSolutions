package chapter8

object Problem1 {

    fun possibleWaysToStep(stepCount: Int) : Int {
        val ways = MutableList(stepCount + 1) { 0 }

        fun countWays(current: Int, max: Int){
            if (current > max) return
            ways[current]++
            countWays(current+1, max)
            countWays(current+2, max)
            countWays(current+3, max)
        }
        countWays(0, stepCount)
        return ways[stepCount]
    }

}