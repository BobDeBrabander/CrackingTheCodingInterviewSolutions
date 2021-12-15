package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem14Tests {

    @Test
    fun `simple test`() {
        val list = listOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
        val result = Problem14.smallestK(list, 5)
        val expect = listOf(1, 3, 4, 5, 7)
        assertThat(result).containsExactlyInAnyOrderElementsOf(expect)
    }

    @Test
    fun `simple test 2`() {
        val list = listOf(15, 10, 14, 16, 25, 1, 3, 19, 20, 4, 5, 7)
        val result = Problem14.smallestK(list, 5)
        val expect = listOf(1, 3, 4, 5, 7)
        assertThat(result).containsExactlyInAnyOrderElementsOf(expect)
    }

    @Test
    fun `simple test 3`() {
        val list = listOf(15, 10, 14, 16, 25, 1, 3, 19, 20, 4, 5, 7)
        val result = Problem14.smallestK(list, 2)
        val expect = listOf(1, 3)
        assertThat(result).containsExactlyInAnyOrderElementsOf(expect)
    }

    @Test
    fun `simple test 4`() {
        val list = listOf(15, 10, 14, 16, 25, 1, 3, 19, 20, 4, 5, 7)
        val result = Problem14.smallestK(list, 11)
        val expect = listOf(1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20)
        assertThat(result).containsExactlyInAnyOrderElementsOf(expect)
    }
}