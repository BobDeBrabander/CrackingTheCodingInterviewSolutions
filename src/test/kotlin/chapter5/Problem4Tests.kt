package chapter5

import chapter5.Problem4.nextBiggestSame1s
import chapter5.Problem4.nextSmallestSame1s
import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.test.assertEquals

class Problem4Tests {

    @Test
    fun `Big number testing both cases`() {
        val A = 1775                   //0011011101111
        val smallestNextSame1s = 1783  //0011011110111
        val biggestNextSame1s = 2935   //0101101110111
        assertEquals(smallestNextSame1s, nextSmallestSame1s(A))
        assertEquals(biggestNextSame1s, nextBiggestSame1s(A))
    }

    @Test
    fun `No overflowing`() {
        val A = 2147483647                   //01111111111111111111111111111111
        assertThrows(Exception::class.java) {nextSmallestSame1s(A)}
        assertThrows(Exception::class.java) {nextBiggestSame1s(A)}
    }

}