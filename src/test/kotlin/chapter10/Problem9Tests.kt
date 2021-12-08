package chapter10

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem9Tests {

    @Test
    fun `simple test`() {
        val row1 = listOf(1, 3, 5, 6)
        val row2 = listOf(3, 4, 6, 8)
        val row3 = listOf(4, 5, 7, 9)
        val row4 = listOf(8, 9, 10, 11)
        val matrix = listOf(row1, row2, row3, row4)

        val result = Problem9.findElement(matrix, 7)
        val expected = 2 to 2
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `simple test 2`() {
        val row1 = listOf(1, 3, 5, 6)
        val row2 = listOf(3, 4, 6, 8)
        val row3 = listOf(4, 5, 7, 9)
        val row4 = listOf(8, 9, 10, 11)
        val matrix = listOf(row1, row2, row3, row4)

        val result = Problem9.findElement(matrix, 3)
        val possibleAnswers = listOf(0 to 1, 1 to 0)
        assertThat(result).isIn(possibleAnswers)
    }

    @Test
    fun `simple test 3`() {
        val row1 = listOf(1, 3, 5, 6)
        val row2 = listOf(3, 4, 6, 8)
        val row3 = listOf(4, 5, 7, 9)
        val row4 = listOf(8, 9, 10, 11)
        val matrix = listOf(row1, row2, row3, row4)

        val result = Problem9.findElement(matrix, 6)
        val possibleAnswers = listOf(0 to 3, 1 to 2)
        assertThat(result).isIn(possibleAnswers)
    }

    @Test
    fun `simple test 4`() {
        val row1 = listOf(1, 3, 5, 6)
        val row2 = listOf(3, 4, 6, 8)
        val row3 = listOf(4, 5, 7, 9)
        val row4 = listOf(8, 9, 10, 11)
        val matrix = listOf(row1, row2, row3, row4)

        val result = Problem9.findElement(matrix, 11)
        val expected = 3 to 3
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `simple test 5`() {
        val row1 = listOf(1, 3, 5, 6)
        val row2 = listOf(3, 4, 6, 8)
        val row3 = listOf(4, 5, 7, 9)
        val row4 = listOf(8, 9, 10, 11)
        val matrix = listOf(row1, row2, row3, row4)

        val result = Problem9.findElement(matrix, 1)
        val expected = 0 to 0
        assertThat(result).isEqualTo(expected)
    }
}