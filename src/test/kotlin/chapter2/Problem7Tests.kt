package chapter2

import chapter2.Problem7.findIntersection
import mydatastructures.MySinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class Problem7Tests {

    @Test
    fun `intersection found test same length`(){
        val node1 = MySinglyLinkedList.Node(1)
        val node2 = MySinglyLinkedList.Node(2)
        node1.next = node2

        val node1L = MySinglyLinkedList.Node(9)
        val node2L = MySinglyLinkedList.Node(8)
        node1L.next = node2L
        node2L.next = node1

        val node1R = MySinglyLinkedList.Node(19)
        val node2R = MySinglyLinkedList.Node(18)
        node1R.next = node2R
        node2R.next = node1

        handleTestCase(node1L, node1R, node1)
    }

    @Test
    fun `intersection found test different length`(){
        val node1 = MySinglyLinkedList.Node(1)
        val node2 = MySinglyLinkedList.Node(2)
        node1.next = node2

        val node0L = MySinglyLinkedList.Node(10)
        val node1L = MySinglyLinkedList.Node(9)
        val node2L = MySinglyLinkedList.Node(8)
        val node3L = MySinglyLinkedList.Node(7)
        node0L.next = node1L
        node1L.next = node2L
        node2L.next = node3L
        node3L.next = node1

        val node1R = MySinglyLinkedList.Node(19)
        val node2R = MySinglyLinkedList.Node(18)
        node1R.next = node2R
        node2R.next = node1

        handleTestCase(node0L, node1R, node1)
    }

    @Test
    fun `no intersection found`(){
        val node0L = MySinglyLinkedList.Node(10)
        val node1L = MySinglyLinkedList.Node(9)
        val node2L = MySinglyLinkedList.Node(8)
        val node3L = MySinglyLinkedList.Node(7)
        node0L.next = node1L
        node1L.next = node2L
        node2L.next = node3L

        val node1R = MySinglyLinkedList.Node(19)
        val node2R = MySinglyLinkedList.Node(18)
        node1R.next = node2R

        handleTestCase(node0L, node1R, null)
    }

    private fun handleTestCase(ll1: MySinglyLinkedList.Node<Int>, ll2: MySinglyLinkedList.Node<Int>, expect: MySinglyLinkedList.Node<Int>?){
        assertEquals(findIntersection(ll1, ll2), expect)
    }

}