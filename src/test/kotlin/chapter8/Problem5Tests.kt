package chapter8

import org.junit.Test
import kotlin.test.assertEquals

class Problem5Tests {

    @Test
    fun `test 1`(){
        val answer = Problem5.recursiveMultiply(2, 3)
        val expect = 6
        assertEquals(expect, answer)
    }

    @Test
    fun `test 2`(){
        val answer = Problem5.recursiveMultiply(4, 17)
        val expect = 68
        assertEquals(expect, answer)
    }

    @Test
    fun `test 3`(){
        val answer = Problem5.recursiveMultiply(123, 237)
        val expect = 29151
        assertEquals(expect, answer)
    }
}