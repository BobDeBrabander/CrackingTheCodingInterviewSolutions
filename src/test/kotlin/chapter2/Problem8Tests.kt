package chapter2

import chapter2.Problem7.findIntersection
import chapter2.Problem8.findStartLoop
import mydatastructures.MySinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class Problem8Tests {

    @Test
    fun `intersection found test same length`(){
        val nodeA = MySinglyLinkedList.Node('A')
        val nodeB = MySinglyLinkedList.Node('B')
        val nodeC = MySinglyLinkedList.Node('C')
        val nodeD = MySinglyLinkedList.Node('D')
        val nodeE = MySinglyLinkedList.Node('E')
        nodeA.next = nodeB
        nodeB.next = nodeC
        nodeC.next = nodeD
        nodeD.next = nodeE
        nodeE.next = nodeC

        handleTestCase(nodeA, nodeC)
    }

    private fun handleTestCase(ll1: MySinglyLinkedList.Node<Char>, expect: MySinglyLinkedList.Node<Char>){
        assertEquals(findStartLoop(ll1), expect)
    }

}