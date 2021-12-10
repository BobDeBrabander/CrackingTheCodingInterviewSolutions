package chapter16

import org.assertj.core.api.Assertions
import org.junit.Test

class Problem17Tests {

    @Test
    fun `example test`() {
        val list = listOf(2, -8, 3, -2, 4, -10)
        val expect = 5
        val result = Problem17.contiguousSeq(list)
        Assertions.assertThat(result).isEqualTo(expect)
    }
}