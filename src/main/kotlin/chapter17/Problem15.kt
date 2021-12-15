package chapter17

object Problem15 {

    fun longestWord(list: List<String>): String? {
        var longestWord: String? = null
        val memo = HashMap<String, Boolean>()
        list.forEach {
            if (isMadeOutOfOtherWords(it, list, memo) && it.length >= (longestWord?.length ?: 0)) {
                longestWord = it
            }
        }
        return longestWord
    }

    private fun isMadeOutOfOtherWords(word: String, list: List<String>, memo: HashMap<String, Boolean>): Boolean {
        if (word.isBlank()) return true
        if (memo.containsKey(word)) return memo[word]!!
        var result = false
        for (i in list.indices){
            val wordStart = list[i]
            if (word.startsWith(wordStart) && isMadeOutOfOtherWords(word.substring(wordStart.length, word.length), list, memo)){
                result = true
                break
            }
        }
        memo[word] = result
        return result
    }
}