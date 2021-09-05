package chapter2

import chapter2.Problem5.sumListsBackwards
import chapter2.Problem5.sumListsForward
import mydatastructures.MySinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class Problem5Tests {

    @Test
    fun `simple test forward`(){
        val ll1 = MySinglyLinkedList<Int>()
        ll1.addAll(listOf(7, 1, 6))
        val ll2 = MySinglyLinkedList<Int>()
        ll2.addAll(listOf(5, 9, 2))

        val llOut = MySinglyLinkedList<Int>()
        llOut.addAll(listOf(2, 1, 9))
        handleTestCaseForward(ll1, ll2, llOut)
    }

    @Test
    fun `simple test forward 2 `(){
        val ll1 = MySinglyLinkedList<Int>()
        ll1.addAll(listOf(7, 1, 6, 8))
        val ll2 = MySinglyLinkedList<Int>()
        ll2.addAll(listOf(5, 9, 2))

        val llOut = MySinglyLinkedList<Int>()
        llOut.addAll(listOf(2, 1, 9, 8))
        handleTestCaseForward(ll1, ll2, llOut)
    }

    @Test
    fun `simple test forward 3`(){
        val ll1 = MySinglyLinkedList<Int>()
        ll1.addAll(listOf(7, 1, 7))
        val ll2 = MySinglyLinkedList<Int>()
        ll2.addAll(listOf(5, 8, 2))

        val llOut = MySinglyLinkedList<Int>()
        llOut.addAll(listOf(2, 0, 0, 1))
        handleTestCaseForward(ll1, ll2, llOut)
    }

    @Test
    fun `simple test backwards`(){
        val ll1 = MySinglyLinkedList<Int>()
        ll1.addAll(listOf(7, 1, 6))
        val ll2 = MySinglyLinkedList<Int>()
        ll2.addAll(listOf(5, 9, 2))

        val llOut = MySinglyLinkedList<Int>()
        llOut.addAll(listOf(1, 3, 0, 8))
        handleTestCaseBackwards(ll1, ll2, llOut)
    }

    @Test
    fun `simple test backwards 2 `(){
        val ll1 = MySinglyLinkedList<Int>()
        ll1.addAll(listOf(7, 1, 6, 8))
        val ll2 = MySinglyLinkedList<Int>()
        ll2.addAll(listOf(5, 9, 2))

        val llOut = MySinglyLinkedList<Int>()
        llOut.addAll(listOf(7, 7, 6, 0))
        handleTestCaseBackwards(ll1, ll2, llOut)
    }

    @Test
    fun `simple test backwards 3`(){
        val ll1 = MySinglyLinkedList<Int>()
        ll1.addAll(listOf(7, 1, 7))
        val ll2 = MySinglyLinkedList<Int>()
        ll2.addAll(listOf(5, 8, 2))

        val llOut = MySinglyLinkedList<Int>()
        llOut.addAll(listOf(1, 2, 9, 9))
        handleTestCaseBackwards(ll1, ll2, llOut)
    }

    private fun handleTestCaseForward(ll1: MySinglyLinkedList<Int>, ll2: MySinglyLinkedList<Int>, expect: MySinglyLinkedList<Int>){
        assertEquals(sumListsForward(ll1, ll2).toList(), expect.toList())
    }

    private fun handleTestCaseBackwards(ll1: MySinglyLinkedList<Int>, ll2: MySinglyLinkedList<Int>, expect: MySinglyLinkedList<Int>){
        assertEquals(sumListsBackwards(ll1, ll2).toList(), expect.toList())
    }
}