package chapter10

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem2Tests {

    @Test
    fun `simple test`() {
        val list = listOf("abcd", "kafs", "dbca", "zxyv", "sfka", "yxvz")
        val result = Problem2.groupAnagrams(list)
        val expected = listOf("abcd", "dbca", "kafs", "sfka", "yxvz", "zxyv")
        assertThat(result).isEqualTo(expected)
    }
}