package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem6Tests {

    @Test
    fun `simple test`() {
        val n = 30
        val result = Problem6.count2s(n)
        val expect = 13 //2, 12, 20, 21, 22 (double 2), 23, 24, 25, 26, 27, 28, 29
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test 2`() {
        val n = 222
        val result = Problem6.count2s(n)
        //2, 12, 20, 21, 22 (double 2), 23, 24, 25, 26, 27, 28, 29, 32, 42, 52, 62, 72, 82, 92,
        // 102, 112, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 132, 142, 152, 162, 172, 182, 192,
        // 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222
        val expect = 69
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test 3`() {
        val n = 99
        val result = Problem6.count2s(n)
        val expect = 20 //2, 12, 20, 21, 22 (double 2), 23, 24, 25, 26, 27, 28, 29, 32, 42, 52, 62, 72, 82, 92
        assertThat(result).isEqualTo(expect)
    }
}