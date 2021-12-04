package chapter8

import org.junit.Test
import kotlin.test.assertEquals

class Problem1Tests {

    @Test
    fun `edge case test 1`(){
        val answer = Problem1.possibleWaysToStep(1)
        val expect = 1
        assertEquals(expect, answer)
    }

    @Test
    fun `edge case test 2`(){
        val answer = Problem1.possibleWaysToStep(0)
        val expect = 1
        assertEquals(expect, answer)
    }

    @Test
    fun `edge case test 3`(){
        val answer = Problem1.possibleWaysToStep(2)
        val expect = 2
        assertEquals(expect, answer)
    }

    @Test
    fun `small test 1`(){
        val answer = Problem1.possibleWaysToStep(3)
        //1 1 1
        //1 2
        //2 1
        //3
        val expect = 4
        assertEquals(expect, answer)
    }

    @Test
    fun `small test 2`(){
        val answer = Problem1.possibleWaysToStep(5)
        //1 1 1 1 1
        //1 1 1 2
        //1 1 2 1
        //1 2 1 1
        //2 1 1 1
        //2 2 1
        //2 1 2
        //1 2 2
        //1 1 3
        //1 3 1
        //3 1 1
        //3 2
        //2 3
        val expect = 13
        assertEquals(expect, answer)
    }
}