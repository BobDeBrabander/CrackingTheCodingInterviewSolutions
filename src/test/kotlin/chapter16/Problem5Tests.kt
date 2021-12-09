package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem5Tests {

    @Test
    fun `small test`(){
        val n = 10
        val result = Problem5.trailingZerosBehindFactorialOf(n)
        //10! = 3628800
        val expected = 2
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `small test 2`(){
        val n = 20
        val result = Problem5.trailingZerosBehindFactorialOf(n)
        //20! = 2432902008176640000
        val expected = 4
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `small test 3`(){
        val n = 99
        val result = Problem5.trailingZerosBehindFactorialOf(n)
        //99! = 933262154439441526816992388562667004907159682643816214685929638952175999932299156089414639761565182862536979208272237582511852109168640000000000000000000000
        val expected = 22
        assertThat(result).isEqualTo(expected)
    }
}