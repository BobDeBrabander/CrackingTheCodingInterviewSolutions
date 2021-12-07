package chapter8

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem12Tests {

    @Test
    fun `test to run code of problem12`(){
        val numSolutions = Problem12.eightQueens()
        assertThat(numSolutions).isEqualTo(92)
    }
}