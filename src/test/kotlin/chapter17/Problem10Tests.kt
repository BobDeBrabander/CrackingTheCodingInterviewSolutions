package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem10Tests {

    @Test
    fun `example test`(){
        val list = listOf(1, 2, 5, 9, 5, 9, 5, 5, 5)
        val result = Problem10.majorityElement(list)
        val expect = 5
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test no majority element`(){
        val list = listOf(1, 2, 5, 9, 5, 9, 1, 2, 3)
        val result = Problem10.majorityElement(list)
        val expect = -1
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test no majority element 2`(){
        val list = listOf(1, 2, 1, 2, 1, 2, 1, 2)
        val result = Problem10.majorityElement(list)
        val expect = -1
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test with majority element`(){
        val list = listOf(1, 2, 1, 2, 1, 2, 1, 2, 1)
        val result = Problem10.majorityElement(list)
        val expect = 1
        assertThat(result).isEqualTo(expect)
    }
}