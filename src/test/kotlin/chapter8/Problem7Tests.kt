package chapter8

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem7Tests {

    @Test
    fun `simple test`(){
        val inputString = "abc"
        val output = Problem7.allPermutationsOf(inputString)
        val expect = setOf("abc", "acb", "bac", "bca", "cba", "cab")
        assertThat(output.size).isEqualTo(expect.size)
        assertThat(output).containsExactlyInAnyOrderElementsOf(expect)
    }

    @Test
    fun `duplicate test`(){
        val inputString = "aab"
        val output = Problem7.allPermutationsOf(inputString)
        val expect = setOf("aab", "aba", "baa")
        assertThat(output.size).isEqualTo(expect.size)
        assertThat(output).containsExactlyInAnyOrderElementsOf(expect)
    }
}