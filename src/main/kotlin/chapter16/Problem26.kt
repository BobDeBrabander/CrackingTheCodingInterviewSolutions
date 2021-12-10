package chapter16

object Problem26 {

    sealed class Token {
        class Operator(val op: Char) : Token()
        class Number(val num: Double) : Token()
    }

    fun calculator(equation: String): Double {
        val tokens = tokenify(equation)
        resolveOperator(tokens, '/')
        resolveOperator(tokens, '*')
        resolveOperator(tokens, '+')
        resolveOperator(tokens, '-')
        return (tokens[0] as Token.Number).num
    }

    private fun resolveOperator(tokens: MutableList<Token>, op: Char) {
        var index = 1
        while (index < tokens.size) {
            val operator = (tokens[index] as Token.Operator)
            if (operator.op == op) {
                val prevNum = (tokens[index - 1] as Token.Number).num
                val nextNum = (tokens[index + 1] as Token.Number).num
                val newNum = executeOp(prevNum, nextNum, op)
                tokens.removeAt(index - 1) //remove prevNum
                tokens.removeAt(index - 1) //remove operator
                tokens[index - 1] = Token.Number(newNum) //overwrite nextNum with newNum
            } else {
                index += 2
            }
        }
    }

    private fun executeOp(num1: Double, num2: Double, op: Char) : Double{
        return when(op){
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            else -> num1 / num2
        }
    }

    private fun tokenify(equation: String): MutableList<Token> {
        val tokens = mutableListOf<Token>()
        var runningNumber = ""
        for (i in equation.indices) {
            when (equation[i]) {
                '*', '+', '-', '/' -> {
                    if (runningNumber.isNotEmpty()) {
                        tokens.add(Token.Number(runningNumber.toDouble()))
                        runningNumber = ""
                    }
                    tokens.add(Token.Operator(equation[i]))
                }
                else -> runningNumber += equation[i]
            }
        }
        if (runningNumber.isNotEmpty()) {
            tokens.add(Token.Number(runningNumber.toDouble()))
        }
        return tokens
    }
}