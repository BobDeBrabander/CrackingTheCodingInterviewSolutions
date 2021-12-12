package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem3Tests {

    @Test
    fun `simple test`() {
        val list = listOf(1, 2, 3, 3, 3, 4, 5, 6, 6, 7, 8, 9, 10)
        val randomSet = Problem3.randomSet(list, 5)
        assertThat(randomSet).hasSize(5)
        assertThat(list).containsAll(randomSet)
    }
}