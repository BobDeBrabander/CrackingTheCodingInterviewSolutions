package chapter10

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem1Tests {

    @Test
    fun `simple test`() {
        val A = mutableListOf(1, 3, 5, 7, 9, -1, -1, -1, -1, -1)
        val B = listOf(2, 4, 6, 8, 10)
        Problem1.mergeBIntoA(A, B)
        assertThat(A).isEqualTo(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    }

    @Test
    fun `A all smaller than B test`() {
        val A = mutableListOf(1, 2, 3, 4, 5, -1, -1, -1, -1, -1)
        val B = listOf(6, 7, 8, 9, 10)
        Problem1.mergeBIntoA(A, B)
        assertThat(A).isEqualTo(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    }

    @Test
    fun `B all smaller than A test`() {
        val A = mutableListOf(6, 7, 8, 9, 10, -1, -1, -1, -1, -1)
        val B = listOf(1, 2, 3, 4, 5)
        Problem1.mergeBIntoA(A, B)
        assertThat(A).isEqualTo(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    }
}