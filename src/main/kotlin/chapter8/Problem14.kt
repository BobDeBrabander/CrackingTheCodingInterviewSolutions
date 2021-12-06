package chapter8

object Problem14 {

    fun booleanEvaluation(expression: String, desiredEval: Boolean): Int {
        return booleanEvaluation(expression, desiredEval, HashMap())
    }

    private fun booleanEvaluation(expression: String, desiredEval: Boolean, memo: HashMap<String, Int>): Int {
        if (expression.isNullOrBlank()) return 0
        if (expression.length == 1) return if ((expression == "1") == desiredEval) 1 else 0

        if (memo.containsKey("$desiredEval$expression")) return memo["$desiredEval$expression"]!!
        var ways = 0

        for (i in 1 until expression.length step 2) {
            val c = expression[i]
            val left = expression.substring(0, i)
            val right = expression.substring(i + 1, expression.length)
            val leftTrue = booleanEvaluation(left, true, memo)
            val leftFalse = booleanEvaluation(left, false, memo)
            val rightTrue = booleanEvaluation(right, true, memo)
            val rightFalse = booleanEvaluation(right, false, memo)
            val total = (leftTrue + leftFalse) * (rightTrue + rightFalse)

            var totalTrue =
                when (c) {
                    '^' -> leftTrue * rightFalse + leftFalse * rightTrue
                    '&' -> leftTrue * rightTrue
                    else -> leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse
                }

            val subWays = if (desiredEval) totalTrue else total - totalTrue
            ways += subWays
        }

        memo["$desiredEval$expression"] = ways
        return ways
    }


}