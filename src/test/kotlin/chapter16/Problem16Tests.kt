package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem16Tests {

    @Test
    fun `example test`() {
        val list = listOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19)
        val expect = 3 to 9
        val result = Problem16.subSort(list)
        assertThat(result).isEqualTo(expect)
    }
}