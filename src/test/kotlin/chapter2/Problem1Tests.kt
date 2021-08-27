package chapter2

import chapter2.Problem1.removeDuplicates
import mydatastructures.MyDoublyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class Problem1Tests {

    @Test
    fun `simple test`(){
        val ll: MyDoublyLinkedList<Int> = MyDoublyLinkedList()
        ll.addAll(listOf(6,1,2,3,1,3,4,5))

        val outll: MyDoublyLinkedList<Int> = MyDoublyLinkedList()
        outll.addAll(listOf(6,1,2,3,4,5))

        handleTestCase(ll, outll)
    }

    fun handleTestCase(inputLL: MyDoublyLinkedList<Int>, expectedOutputLL: MyDoublyLinkedList<Int>){
        assertEquals(inputLL.removeDuplicates().toList(), expectedOutputLL.toList())
    }

}