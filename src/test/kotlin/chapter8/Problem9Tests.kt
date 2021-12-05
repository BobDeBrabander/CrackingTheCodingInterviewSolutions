package chapter8

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem9Tests {

    @Test
    fun `simple test`(){
        val output = Problem9.parens(3)
        val expect = setOf("((()))", "(()())", "(())()", "()(())", "()()()")
        assertThat(output.size).isEqualTo(expect.size)
        assertThat(output).containsExactlyInAnyOrderElementsOf(expect)
    }

}