package chapter8

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `simple test with magic index and duplicates`() {
        val list = listOf(0, 1, 3, 3, 3, 4, 6, 6, 7, 8)
        val magicIndex = Problem3.findMagicIndexWithDuplicates(list)
        val expectList = listOf(0, 1, 3, 6)
        assertThat(expectList).contains(magicIndex)
    }
}