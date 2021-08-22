package chapter2

import chapter2.Problem1.removeDuplicates
import org.junit.Test
import java.util.LinkedList
import kotlin.test.assertEquals

class Problem1Tests {

    @Test
    fun `simple test`(){
        val ll: LinkedList<Int> = LinkedList()
        ll.addAll(listOf(6,1,2,3,1,3,4,5))

        val outll: LinkedList<Int> = LinkedList()
        outll.addAll(listOf(6,1,2,3,4,5))

        handleTestCase(ll, outll)
    }

    fun handleTestCase(inputLL: LinkedList<Int>, expectedOutputLL: LinkedList<Int>){
        assertEquals(inputLL.removeDuplicates(), expectedOutputLL)
    }

}