package chapter5

import chapter5.Problem1.solve
import org.junit.Test
import kotlin.test.assertEquals

class Problem1Tests {

    @Test
    fun `test from example`(){
        val N = 1024        //10000000000
        val M = 19          //10011
        val i = 2
        val j = 6
        val expect = 1100   //10001001100
    }

    @Test
    fun `my own test asserting the overwriting`(){
        val N = 1148        //10001111100
        val M = 19          //10011
        val i = 2
        val j = 6
        val expect = 1100   //10001001100
    }

    fun runTest(M: Int, N: Int, i: Int, j: Int, expect: Int){
        assertEquals(expect, solve(M, N, i, j))
    }
}