package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem26Tests {

    @Test
    fun `example test`(){
        val equation = "2*3+5/6*3+15"
        val result = Problem26.calculator(equation)
        val expect = 23.5
        assertThat(result).isEqualTo(expect)
    }
}