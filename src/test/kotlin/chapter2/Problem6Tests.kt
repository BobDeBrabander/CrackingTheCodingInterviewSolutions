package chapter2

import chapter2.Problem6.isPalindrome
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import mydatastructures.MySinglyLinkedList
import org.junit.Test

class Problem6Tests {

    @Test
    fun `is palindrome test 1`(){
        val ll = MySinglyLinkedList<Int>()
        ll.addAll(listOf(7, 1, 7))
        handleTestCase(ll, true)
    }

    @Test
    fun `is palindrome test 2`(){
        val ll = MySinglyLinkedList<Int>()
        ll.addAll(listOf(7, 1, 4, 1, 7))
        handleTestCase(ll, true)
    }

    @Test
    fun `is not palindrome test 1`(){
        val ll = MySinglyLinkedList<Int>()
        ll.addAll(listOf(7, 3, 4, 1, 7))
        handleTestCase(ll, false)
    }

    @Test
    fun `is not palindrome test 2`(){
        val ll = MySinglyLinkedList<Int>()
        ll.addAll(listOf(7, 3, 4, 1, 8))
        handleTestCase(ll, false)
    }

    @Test
    fun `is palindrome edge test 1`(){
        val ll = MySinglyLinkedList<Int>()
        ll.addAll(listOf(7))
        handleTestCase(ll, true)
    }

    fun handleTestCase(ll: MySinglyLinkedList<Int>, exp: Boolean){
        if (exp){
            assertTrue(isPalindrome(ll))
        } else {
            assertFalse(isPalindrome(ll))
        }
    }
}