package chapter8

object Problem7 {

    fun allPermutationsOf(inputString: String) : Set<String>{
        return allPermutationsOf("", inputString)
    }

    private fun allPermutationsOf(currentString: String, charactersLeftToUse: String) : Set<String>{
        if (charactersLeftToUse.isNullOrBlank()) return setOf(currentString)
        val answer = mutableSetOf<String>()
        charactersLeftToUse.forEachIndexed{ indexToRemove, char ->
            val charsLeft = charactersLeftToUse.filterIndexed { index, c -> index != indexToRemove }
            answer.addAll(allPermutationsOf(currentString+char, charsLeft))
        }
        return answer
    }
}