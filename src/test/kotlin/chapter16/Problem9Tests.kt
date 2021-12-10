package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem9Tests {

    @Test
    fun `subtract test 1`(){
        val a = 4
        val b = 1
        val result = Problem9.subtract(a, b)
        val expect = 3
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `subtract test 2`(){
        val a = 4
        val b = -1
        val result = Problem9.subtract(a, b)
        val expect = 5
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `subtract test 3`(){
        val a = -4
        val b = -1
        val result = Problem9.subtract(a, b)
        val expect = -3
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `multiply test 1`(){
        val a = 15
        val b = 7
        val result = Problem9.multiply(a, b)
        val expect = 105
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `multiply test 2`(){
        val a = 7
        val b = -5
        val result = Problem9.multiply(a, b)
        val expect = -35
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `multiply test 3`(){
        val a = -7
        val b = -9
        val result = Problem9.multiply(a, b)
        val expect = 63
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `multiply test 4`(){
        val a = 0
        val b = -4
        val result = Problem9.multiply(a, b)
        val expect = 0
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `divide test 1`(){
        val a = 3
        val b = 4
        val result = Problem9.divide(a, b)
        val expect = 0
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `divide test 2`(){
        val a = 4
        val b = 4
        val result = Problem9.divide(a, b)
        val expect = 1
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `divide test 3`(){
        val a = 7
        val b = 4
        val result = Problem9.divide(a, b)
        val expect = 1
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `divide test 4`(){
        val a = -7
        val b = 4
        val result = Problem9.divide(a, b)
        val expect = -1
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `divide test 5`(){
        val a = -7
        val b = -3
        val result = Problem9.divide(a, b)
        val expect = 2
        assertThat(result).isEqualTo(expect)
    }
}