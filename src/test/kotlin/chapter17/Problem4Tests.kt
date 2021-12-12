package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem4Tests {

    @Test
    fun `simple test`() {
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15)
        val bitList = Problem4.BitList(list)
        val result = Problem4.missingNumber(bitList, 15)
        val expect = 13
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test 2`() {
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 9)
        val bitList = Problem4.BitList(list)
        val result = Problem4.missingNumber(bitList, 9)
        val expect = 8
        assertThat(result).isEqualTo(expect)
    }
}