package chapter2

import chapter2.Problem2.kthToLast
import chapter2.Problem2.kthToLastWithoutSize
import mydatastructures.MySinglyLinkedList
import org.junit.Test
import kotlin.test.assertEquals

class Problem2Tests {

    @Test
    fun `simple test`(){
        val ll = MySinglyLinkedList<Int>()
        ll.addAll(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        handleTest(ll, 0, 10)
        handleTest(ll, 1, 9)
        handleTest(ll, 5, 5)
        handleTest(ll, 8, 2)
        handleTest(ll, 9, 1)
    }

    fun handleTest(ll: MySinglyLinkedList<Int>, k: Int, expectedOut: Int){
        assertEquals(ll.kthToLast(k)?.value, expectedOut)
        assertEquals(ll.kthToLastWithoutSize(k)?.value, expectedOut)
    }
}