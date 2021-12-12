package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem5Tests {

    @Test
    fun `simple test`() {
        val list = listOf('a', 'b', 'c', '1', '2', '3', 'c', 'f', '1', 'f', 'b')
        val result = Problem5.longestSubArray(list)
        val expectList = listOf(3 to 10, 1 to 8)
        assertThat(result).isIn(expectList)
    }

    @Test
    fun `simple test 2`() {
        val list = listOf('c', 'f', '1', 'f', 'b', 'a', 'b', 'c', '1', '2', '3')
        val result = Problem5.longestSubArray(list)
        val expect = 5 to 10
        assertThat(result).isEqualTo(expect)
    }
}