package chapter8

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
class Problem4Tests {

    @Test
    fun `small test 1`(){
        val set = setOf(1, 2, 3)
        val answer = Problem4.powerSet(set)
        val expect = listOf(
            setOf(1),
            setOf(2),
            setOf(3),
            setOf(1, 2),
            setOf(1, 3),
            setOf(2, 3),
            setOf(1, 2, 3),
            setOf()
        )
        assertThat(answer).containsAll(expect)
    }
}