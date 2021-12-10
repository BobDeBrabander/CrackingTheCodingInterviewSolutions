package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem15Tests {

    @Test
    fun `example test`() {
        val actual = "RGBY"
        val guess = "GGRR"
        val result = Problem15.guessResult(actual, guess)
        val expect = Problem15.GuessResult(1, 1)
        assertThat(result).isEqualTo(expect)
    }
}