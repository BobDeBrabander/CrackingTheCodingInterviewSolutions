package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem19Tests {

    @Test
    fun `simple test`() {
        val list = listOf(1, 2, 3, 4, 5, 7, 8, 9, 10)
        val result = Problem19.missingOne(list)
        val expect = 6
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test 2`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val result = Problem19.missingOne(list)
        val expect = 10
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test 3`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val result = Problem19.missingOne(list)
        val expect = 9
        assertThat(result).isEqualTo(expect)
    }
}