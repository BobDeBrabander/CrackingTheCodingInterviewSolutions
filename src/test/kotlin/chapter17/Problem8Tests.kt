package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem8Tests {

    @Test
    fun `example test`() {
        val towers = listOf(65 to 100, 70 to 150, 56 to 90, 75 to 190, 60 to 95, 68 to 110)
            .map { (height, width) -> Problem8.Tower(height, width) }
        val result = Problem8.circusTower(towers)
        val expect = 6
        assertThat(result).isEqualTo(expect)
    }
}