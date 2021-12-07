package chapter8

object Problem1 {

    fun possibleWaysToStep(stepCount: Int): Int {
        fun countWays(n: Int, memo: HashMap<Int, Int>): Int {
            if (memo[n] != null) return memo[n]!!
            if (n < 0) return 0
            if (n == 0) return 1
            val ans = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo)
            memo[n] = ans
            return memo[n]!!
        }
        return countWays(stepCount, HashMap())
    }

}