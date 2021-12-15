package chapter17

import kotlin.math.abs
import kotlin.math.min

object Problem11 {

    class WordDistanceLookup(words: List<String>) {
        private val wordsToIndex = HashMap<String, MutableList<Int>>()
        init {
            words.forEachIndexed { index, word ->
                if (wordsToIndex.containsKey(word)) {
                    wordsToIndex[word]?.add(index)
                } else {
                    wordsToIndex[word] = mutableListOf(index)
                }
            }

        }

        fun minDistance(word1: String, word2: String): Int {
            if (!wordsToIndex.containsKey(word1) || !wordsToIndex.containsKey(word2)) return -1 //One of the words (or both) does not exist
            val indexList1 = wordsToIndex[word1]!!
            val indexList2 = wordsToIndex[word2]!!
            return smallestDifference(indexList1, indexList2)
        }

        //Copied from problem 16.6
        private fun smallestDifference(l1: List<Int>, l2: List<Int>): Int {
            val sl1 = l1.sorted()
            val sl2 = l2.sorted()
            var smallestDiff = abs(sl2[0] - sl1[0])
            var i1 = 0
            var i2 = 0
            while (i1 < l1.size && i2 < l2.size) {
                smallestDiff = min(smallestDiff, abs(sl2[i2] - sl1[i1]))
                if (i1+1 >= l1.size && i2+1 >= l2.size) break
                if (i1+1 >= l1.size){
                    i2++
                    continue
                }
                if (i2+1 >= l2.size){
                    i1++
                    continue
                }
                if (sl1[i1] <= sl2[i2]){
                    i1++
                } else {
                    i2++
                }
            }
            return smallestDiff
        }
    }
}