package chapter8

object Problem9 {

    fun parens(num: Int) : List<String>{
        return parens("", 0, num)
    }

    private fun parens(current: String, openBrackets: Int, toOpenLeft: Int) : List<String>{
        if (openBrackets == 0 && toOpenLeft == 0) return listOf(current)
        val answer = mutableListOf<String>()
        if (toOpenLeft > 0) {
            answer.addAll(parens("$current(", openBrackets+1, toOpenLeft-1))
        }
        if (openBrackets > 0){
            answer.addAll(parens("$current)", openBrackets-1, toOpenLeft))
        }
        return answer
    }
}