package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem6Tests {

    @Test
    fun `example test`() {
        val l1 = listOf(1, 3, 15, 11, 2)
        val l2 = listOf(23, 127, 235, 19, 8)

        val result = Problem6.smallestDifference(l1, l2)
        val expect = 3 //11 and 8
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test`() {
        val l1 = listOf(1, 2, 3, 11, 15)
        val l2 = listOf(8, 19, 12, 127, 235, 5, 18, 56)

        val result = Problem6.smallestDifference(l1, l2)
        val expect = 1 //11 and 12
        assertThat(result).isEqualTo(expect)
    }
}