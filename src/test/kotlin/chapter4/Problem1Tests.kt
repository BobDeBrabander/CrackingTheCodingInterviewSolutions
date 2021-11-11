package chapter4

import chapter4.Problem1.canReach
import org.junit.Test
import kotlin.test.assertEquals

class Problem1Tests {

    @Test
    fun `Testing reachability and non-reachability`() {
        val graph = Problem1.Graph(5)
        val node1 = graph.nodes[0]
        val node2 = graph.nodes[1]
        val node3 = graph.nodes[2]
        val node4 = graph.nodes[3]
        val node5 = graph.nodes[4]

        node1.addEdge(node2)
        node2.addEdge(node3)
        node3.addEdge(node5)
        node5.addEdge(node4)
        node4.addEdge(node3)

        doCheck(graph, node1, node2, true)
        doCheck(graph, node1, node3, true)
        doCheck(graph, node1, node4, true)
        doCheck(graph, node1, node5, true)
        doCheck(graph, node2, node1, false)
        doCheck(graph, node2, node3, true)
        doCheck(graph, node2, node4, true)
        doCheck(graph, node2, node5, true)
        doCheck(graph, node3, node1, false)
        doCheck(graph, node3, node2, false)
        doCheck(graph, node3, node4, true)
        doCheck(graph, node3, node5, true)
        doCheck(graph, node4, node1, false)
        doCheck(graph, node4, node2, false)
        doCheck(graph, node4, node3, true)
        doCheck(graph, node4, node5, true)
        doCheck(graph, node5, node1, false)
        doCheck(graph, node5, node2, false)
        doCheck(graph, node5, node3, true)
        doCheck(graph, node5, node4, true)
    }

    fun doCheck(graph: Problem1.Graph, node1: Problem1.Node, node2: Problem1.Node, expected: Boolean) {
        assertEquals(expected, node1.canReach(node2))
        graph.resetGraph()
    }

}