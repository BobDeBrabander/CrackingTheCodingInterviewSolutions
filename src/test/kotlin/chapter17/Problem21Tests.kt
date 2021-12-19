package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem21Tests {

    @Test
    fun `example test`(){
        val list = listOf(0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0)
        val result = Problem21.volumeOfHistogram(list)
        val expect = 26
        assertThat(result).isEqualTo(expect)
    }
}