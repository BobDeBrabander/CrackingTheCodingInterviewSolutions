package chapter17

object Problem7 {

    class FrequencyNode (val name: String, val frequency: Int){
        var visited = false
        val adj = mutableListOf<FrequencyNode>()

        fun addLink(other: FrequencyNode) {
            adj.add(other)
        }
    }

    private fun componentFrequency(node: FrequencyNode) : Int {
        if (node.visited) return 0
        node.visited = true
        var sum = node.frequency
        node.adj.forEach {
            sum += componentFrequency(it)
        }
        return sum
    }

    fun babyNames(frequencyMap: Map<String, Int>, synonyms: List<Pair<String, String>>): Map<String, Int> {
        val nodes = frequencyMap.map{ (name, frequency) -> name to FrequencyNode(name, frequency)}.toMap()
        synonyms.forEach { (name1, name2) ->
            nodes[name1]?.addLink(nodes[name2]!!)
            nodes[name2]?.addLink(nodes[name1]!!)
        }
        return nodes.values.mapNotNull {
            if (it.visited) null
            else it.name to componentFrequency(it)
        }.toMap()
    }
}