package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem18Tests {

    @Test
    fun `example test`(){
        val bigList = listOf(7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7)
        val shortList = listOf(1, 5, 9)
        val result = Problem18.shortestSupersequence(shortList, bigList)
        val expect = 7 to 10
        assertThat(result).isEqualTo(expect)
    }
}