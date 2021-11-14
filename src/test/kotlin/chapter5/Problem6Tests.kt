package chapter5

import org.junit.Test
import kotlin.test.assertEquals

class Problem6Tests {

    @Test
    fun `test from example`(){
        val A = 29        //11101
        val B = 15        //01111
        val expect = 2
        runTest(A, B, expect)
    }


    @Test
    fun `my own test example`(){
        val A = -29       //11111111111111111111111111100011
        val B = 15        //00000000000000000000000000001111
        val expect = 29
        runTest(A, B, expect)
    }


    fun runTest(A: Int, B: Int, expect: Int){
        assertEquals(expect, Problem6.solve(A, B))
    }
}