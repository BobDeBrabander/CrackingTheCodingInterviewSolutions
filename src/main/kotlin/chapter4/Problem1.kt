package chapter4

object Problem1 {

    class Graph(nodeNum: Int) {
        val nodes = MutableList(nodeNum) { Node() }

        fun resetGraph() {
            nodes.forEach { it.seen = false }
        }
    }

    class Node {
        val adj = mutableListOf<Node>()
        var seen = false

        fun addEdge(node: Node) {
            adj.add(node)
        }
    }

    //DFS
    fun Node.canReach(otherNode: Node): Boolean {
        this.seen = true
        this.adj
            .filter { it.seen == false }
            .forEach { it.canReach(otherNode) }
        return otherNode.seen
    }
}