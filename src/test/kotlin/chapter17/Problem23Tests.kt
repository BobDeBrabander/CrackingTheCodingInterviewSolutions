package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem23Tests {

    @Test
    fun `simple test`(){
        val row1 = listOf(1, 1, 1, 1)
        val row2 = listOf(1, 0, 1, 0)
        val row3 = listOf(1, 1, 0, 1)
        val row4 = listOf(1, 1, 0, 0)
        val matrix = listOf(row1, row2, row3, row4)

        val result = Problem23.maxSubSquare(matrix)
        val expect = Problem23.SubSquareMatrix(Problem23.Cell(2, 0), 2)
        assertThat(result).isEqualTo(expect)
    }
}