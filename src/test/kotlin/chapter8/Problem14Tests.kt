package chapter8

import org.junit.Test
import kotlin.test.assertEquals

class Problem14Tests {

    @Test
    fun `example test 1`(){
        val expected = 2
        val output = Problem14.booleanEvaluation("1^0|0|1", false)
        assertEquals(expected, output)
    }

    @Test
    fun `example test 2`(){
        val expected = 10
        val output = Problem14.booleanEvaluation("0&0&0&1^1|0", true)
        assertEquals(expected, output)
    }
}