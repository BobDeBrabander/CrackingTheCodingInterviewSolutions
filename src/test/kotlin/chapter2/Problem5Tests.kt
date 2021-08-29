package chapter2

import chapter2.Problem5.sumListsForward
import mydatastructures.MySinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class Problem5Tests {

    @Test
    fun `simple test`(){
        val ll1 = MySinglyLinkedList<Int>()
        ll1.addAll(listOf(7, 1, 6))
        val ll2 = MySinglyLinkedList<Int>()
        ll2.addAll(listOf(5, 9, 2))

        val llOut = MySinglyLinkedList<Int>()
        llOut.addAll(listOf(2, 1, 9))
    }

    fun handleTestCase(ll1: MySinglyLinkedList<Int>, ll2: MySinglyLinkedList<Int>, expect: MySinglyLinkedList<Int>){
        assertEquals(sumListsForward(ll1, ll2).toList(), expect.toList())
    }
}