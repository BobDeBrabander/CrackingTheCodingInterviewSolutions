package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem24Tests {

    @Test
    fun `simple test`() {
        val list = listOf(4, 4, 7, 1, 3, 5, 11, 2, -3)
        val result = Problem24.pairsWithSum(list, 8)
        val expected = setOf(
            4 to 4,
            1 to 7,
            3 to 5,
            -3 to 11
        )
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected)
    }
}