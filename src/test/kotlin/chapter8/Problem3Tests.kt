package chapter8

import org.junit.Test
import kotlin.test.assertEquals

class Problem3Tests {

    @Test
    fun `simple test with magic index`() {
        val list = listOf(-1, 0, 1, 3, 5, 6, 7)
        val magicIndex = Problem3.findMagicIndex(list)
        val expect = 3
        assertEquals(expect, magicIndex)
    }

    @Test
    fun `simple test with no magic index`() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val magicIndex = Problem3.findMagicIndex(list)
        val expect = -1
        assertEquals(expect, magicIndex)
    }
}