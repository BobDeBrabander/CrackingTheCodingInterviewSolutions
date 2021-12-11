package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem7Tests {

    @Test
    fun `simple test`() {
        val num1 = 15
        val num2 = 7
        val expect = 15
        assertThat(Problem7.maxNumberOf(num1, num2)).isEqualTo(expect)
    }

    @Test
    fun `simple test 2`() {
        val num1 = -10
        val num2 = 20
        val expect = 20
        assertThat(Problem7.maxNumberOf(num1, num2)).isEqualTo(expect)
    }

    @Test
    fun `simple test 3`() {
        val num1 = -10
        val num2 = -20
        val expect = -10
        assertThat(Problem7.maxNumberOf(num1, num2)).isEqualTo(expect)
    }

    @Test
    fun `simple test 4`() {
        val num1 = -10
        val num2 = 8
        val expect = 8
        assertThat(Problem7.maxNumberOf(num1, num2)).isEqualTo(expect)
    }

    @Test
    fun `overflow test`() {
        val num1 = Int.MAX_VALUE
        val num2 = Int.MIN_VALUE
        val expect = Int.MAX_VALUE
        assertThat(Problem7.maxNumberOf(num1, num2)).isEqualTo(expect)
    }
}