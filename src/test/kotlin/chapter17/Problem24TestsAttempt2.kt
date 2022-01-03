package chapter17

import org.assertj.core.api.Assertions.assertThat
import chapter17.Problem24Attempt2.Cell
import chapter17.Problem24Attempt2.SubMatrix
import org.junit.Test

class Problem24TestsAttempt2 {

    @Test
    fun `simple test`() {
        val row1 = listOf(14, 12, 9, 9)
        val row2 = listOf(4, -9, 1, 8)
        val row3 = listOf(20, 6, 12, 9)
        val row4 = listOf(-16, 4, 9, 9)
        val matrix = listOf(row1, row2, row3, row4)

        val result = Problem24Attempt2.maxSubMatrix(matrix)
        val expect = SubMatrix(Cell(0, 0), Cell(3, 3))
        assertThat(result).isEqualTo(expect)
    }
}