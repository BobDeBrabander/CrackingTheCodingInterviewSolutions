package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem21Tests {

    @Test
    fun `example test`() {
        val l1 = listOf(4, 1, 2, 1, 1, 2)
        val l2 = listOf(3, 6, 3, 3)
        val result = Problem21.sumSwap(l1, l2)
        val expect = 1 to 3
        assertThat(result).isEqualTo(expect)
    }
}