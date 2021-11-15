package chapter5

import chapter5.Problem7.pairWiseSwap
import org.junit.Test
import kotlin.test.assertEquals

class Problem7Tests {

    @Test
    fun `Simple testcase`() {
        val A = 29        //00011101
        val expect = 46   //00101110
        runTest(A, expect)
    }

    @Test
    fun `Big testcase`() {
        val A = 1431655765        //01010101010101010101010101010101
        val expect = -1431655766  //10101010101010101010101010101010
        runTest(A, expect)
    }


    fun runTest(A: Int, expect: Int) {
        assertEquals(expect, pairWiseSwap(A))
    }
}