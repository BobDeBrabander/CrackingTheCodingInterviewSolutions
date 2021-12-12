package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem1Tests {

    @Test
    fun `simple test`() {
        val n1 = 17
        val n2 = 15
        val result = Problem1.addWithoutPlus(n1, n2)
        val expect = 32
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `big test`() {
        val n1 = 1234
        val n2 = 8766
        val result = Problem1.addWithoutPlus(n1, n2)
        val expect = 10000
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `overflow test`(){
        val n1 = Int.MAX_VALUE
        val n2 = 1
        val result = Problem1.addWithoutPlus(n1, n2)
        val expect = Int.MIN_VALUE
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `test with negative number 1`() {
        val n1 = -1234
        val n2 = 1234
        val result = Problem1.addWithoutPlus(n1, n2)
        val expect = 0
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `test with 2 negative numbers`() {
        val n1 = -1234
        val n2 = -1234
        val result = Problem1.addWithoutPlus(n1, n2)
        val expect = -2468
        assertThat(result).isEqualTo(expect)
    }


    @Test
    fun `test add negative to positive number`() {
        val n1 = 1234
        val n2 = -1234
        val result = Problem1.addWithoutPlus(n1, n2)
        val expect = 0
        assertThat(result).isEqualTo(expect)
    }

}