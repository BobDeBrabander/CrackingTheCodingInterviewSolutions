package chapter17

import java.lang.StringBuilder

object Problem13 {

    data class RespaceResult (val resultString: String, val unrecognizedChars: Int){
        fun mergeWith(other: RespaceResult) : RespaceResult{
            return if (resultString.length == unrecognizedChars && other.resultString.length == other.unrecognizedChars){
                RespaceResult("$resultString${other.resultString}", unrecognizedChars+other.unrecognizedChars)
            } else {
                RespaceResult("$resultString ${other.resultString}", unrecognizedChars+other.unrecognizedChars)
            }
        }
    }

    fun reSpace(unspacedWord: String, wordList: List<String>) : String {
        val memo = HashMap<Int, RespaceResult>()
        return reSpace(unspacedWord, 0, wordList, memo).resultString.trim()
    }

    private fun reSpace(unspacedWord: String, startIndex: Int, wordList: List<String>, memo: HashMap<Int, RespaceResult>) : RespaceResult {
        if (startIndex >= unspacedWord.length) return RespaceResult("", 0)
        if (memo.containsKey(startIndex)) return memo[startIndex]!!

        var best = RespaceResult(unspacedWord, unspacedWord.length)
        wordList.forEach { word ->
            if (containsWordAt(unspacedWord, startIndex, word)) {
                val resultStart = RespaceResult(word, 0)
                val resultEnd = reSpace(unspacedWord, startIndex+word.length, wordList, memo)
                if (resultEnd.unrecognizedChars < best.unrecognizedChars) {
                    best = resultStart.mergeWith(resultEnd)
                }
            }
        }

        val sb = StringBuilder()
        for (i in 0..unspacedWord.length-1-startIndex) {
            if (i >= best.unrecognizedChars) break
            sb.append(unspacedWord[startIndex+i])
            val resultEnd = reSpace(unspacedWord, startIndex+i+1, wordList, memo)
            if (i + resultEnd.unrecognizedChars < best.unrecognizedChars) {
                best = RespaceResult("$sb", i+1).mergeWith(resultEnd)
            }
        }

        memo[startIndex] = best
        return memo[startIndex]!!
    }

    private fun containsWordAt(unspacedWord: String, startIndex: Int, word: String) : Boolean{
        if (startIndex >= unspacedWord.length || startIndex+word.length > unspacedWord.length) return false
        for (i in word.indices) {
            if (unspacedWord[startIndex+i] != word[i]) return false
        }
        return true
    }
}