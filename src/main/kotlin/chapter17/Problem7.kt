package chapter17

object Problem7 {

    fun babyNames(frequencyMap: Map<String, Int>, synonyms: List<Pair<String, String>>): Map<String, Int> {
        val copiedFrequencyMap = frequencyMap.toMutableMap()
        val adjacencyList = mutableMapOf<String, MutableList<String>>()
        frequencyMap.keys.forEach { adjacencyList[it] = mutableListOf() }
        synonyms.forEach { (name1, name2) -> adjacencyList[name1]?.add(name2) }

        fun takeFrequencyUpstream(name: String): Int {
            val ans = (adjacencyList[name]?.map { takeFrequencyUpstream(it) }?.sum() ?: 0) + copiedFrequencyMap[name]!!
            adjacencyList.remove(name)
            copiedFrequencyMap.remove(name)
            return ans
        }

        while (adjacencyList.isNotEmpty()) {
            val parent = adjacencyList.keys.first()
            val children = adjacencyList[parent]!!
            children.forEach { child ->
                copiedFrequencyMap[parent] = copiedFrequencyMap[parent]!! + takeFrequencyUpstream(child)
            }
            adjacencyList.remove(parent)
        }
        return copiedFrequencyMap
    }
}