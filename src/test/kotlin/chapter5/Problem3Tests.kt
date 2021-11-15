package chapter5

import chapter5.Problem3.flipToWin
import org.junit.Test
import kotlin.test.assertEquals

class Problem3Tests {

    @Test
    fun `Example testcase`(){
        val A = 1775        //11011101111
        val expect = 8
        runTest(A, expect)
    }

    @Test
    fun `Correct sequences should be merged`(){
        val A = 16111       //11111011101111
        val expect = 9
        runTest(A, expect)
    }


    @Test
    fun `If no merges can be done, lengthen the longest sequence by 1`(){
        val A = 15591       //11110011100111
        val expect = 5
        runTest(A, expect)
    }


    fun runTest(A: Int, expect: Int){
        assertEquals(expect, flipToWin(A))
    }
}