package chapter4

object Problem7 {

    class BuildNode(val buildChar: Char) : Comparable<BuildNode> {
        var dependencies: MutableList<BuildNode> = mutableListOf()
        var children: MutableList<BuildNode> = mutableListOf()

        override fun compareTo(other: BuildNode): Int {
            return this.dependencies.size - other.dependencies.size
        }
    }

    fun solve(projects: List<Char>, dependencies: List<Pair<Char, Char>>): List<Char> {
        val nodes = projects.map { it to BuildNode(it) }.toMap()
        dependencies.forEach { (dependency, child) ->
            nodes[child]!!.dependencies.add(nodes[dependency]!!)
            nodes[dependency]!!.children.add(nodes[child]!!)
        }

        val buildQueue = ArrayDeque<BuildNode>()
        buildQueue.addAll(nodes.values.filter { it.dependencies.isEmpty() })

        val buildOrder = mutableListOf<Char>()
        while (buildQueue.isNotEmpty()) {
            val nextBuild = buildQueue.removeFirst()
            buildOrder.add(nextBuild.buildChar)
            nextBuild.children.forEach {
                it.dependencies.remove(nextBuild)
                if (it.dependencies.isEmpty()) buildQueue.add(it)
            }
        }
        if (buildOrder.size != projects.size) throw ImpossibleBuildError("No build order found")
        return buildOrder
    }

    class ImpossibleBuildError(msg: String) : Exception(msg)
}