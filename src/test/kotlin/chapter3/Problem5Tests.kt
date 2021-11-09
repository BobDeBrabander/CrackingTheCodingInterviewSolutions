package chapter3

import org.junit.Test
import java.util.Stack
import kotlin.test.assertEquals
import chapter3.Problem5.sort

class Problem5Tests {

    @Test
    fun `simple sort case`() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(5)
        stack.push(3)
        stack.push(7)
        stack.push(2)

        val expected = Stack<Int>()
        expected.push(7)
        expected.push(5)
        expected.push(3)
        expected.push(2)
        expected.push(1)

        handleTestCase(stack, expected)
    }

    @Test
    fun `edge case 1`() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(1)
        stack.push(2)

        val expected = Stack<Int>()
        expected.push(3)
        expected.push(2)
        expected.push(2)
        expected.push(1)
        expected.push(1)

        handleTestCase(stack, expected)
    }

    @Test
    fun `edge case 2`() {
        val stack = Stack<Int>()
        stack.push(1)

        val expected = Stack<Int>()
        expected.push(1)

        handleTestCase(stack, expected)
    }

    private fun handleTestCase(input: Stack<Int>, expect: Stack<Int>) {
        assertEquals(input.sort(), expect)
    }

}