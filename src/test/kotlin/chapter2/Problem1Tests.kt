package chapter2

import chapter2.Problem1.removeDuplicates
import mydatastructures.MyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class Problem1Tests {

    @Test
    fun `simple test`(){
        val ll: MyLinkedList<Int> = MyLinkedList()
        ll.addAll(listOf(6,1,2,3,1,3,4,5))

        val outll: MyLinkedList<Int> = MyLinkedList()
        outll.addAll(listOf(6,1,2,3,4,5))

        handleTestCase(ll, outll)
    }

    fun handleTestCase(inputLL: MyLinkedList<Int>, expectedOutputLL: MyLinkedList<Int>){
        assertEquals(inputLL.removeDuplicates().toList(), expectedOutputLL.toList())
    }

}