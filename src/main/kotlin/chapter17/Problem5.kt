package chapter17

object Problem5 {

    fun longestSubArray(list: List<Char>): Pair<Int, Int>? {
        var deltaList = MutableList(list.size) { 0 }
        val indexMap = mutableMapOf<Int, MutableList<Int>>()
        indexMap[0] = mutableListOf(-1)

        for (i in list.indices) {
            if (list[i] in '0'..'9') deltaList[i] = (deltaList.getOrNull(i - 1) ?: 0) + 1
            else deltaList[i] = (deltaList.getOrNull(i - 1) ?: 0) - 1

            if (indexMap.containsKey(deltaList[i])) {
                indexMap[deltaList[i]]?.add(i)
            } else {
                indexMap[deltaList[i]] = mutableListOf(i)
            }

        }
        var biggestSubArray = 0
        var biggestSubArrayIndices: Pair<Int, Int>? = null
        indexMap.entries.forEach { (frequency, indexList) ->
            if (indexList.size > 1) {
                val start = indexList[0]
                val end = indexList[indexList.size - 1]
                if (end - start > biggestSubArray) {
                    biggestSubArray = end - start
                    biggestSubArrayIndices = start+1 to end
                }
            }
        }
        return biggestSubArrayIndices
    }
}