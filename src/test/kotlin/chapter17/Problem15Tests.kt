package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem15Tests {

    @Test
    fun `example test`() {
        val list = listOf("cat", "banana", "dog", "nana", "walk", "walker", "dogwalker")
        val result = Problem15.longestWord(list)
        val expect = "dogwalker"
        assertThat(result).isEqualTo(expect)
    }
}