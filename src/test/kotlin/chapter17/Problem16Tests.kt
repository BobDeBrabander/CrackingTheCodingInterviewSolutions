package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem16Tests {

    @Test
    fun `example test`(){
        val list = listOf(30, 15, 60, 75, 45, 15, 15, 45)
        val result = Problem16.masseuse(list)
        val expect = 180
        assertThat(result).isEqualTo(expect)
    }
}