package chapter10

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem3Tests {

    @Test
    fun `example test`(){
        val list = listOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
        val result = Problem3.searchInRotatedArray(list, 5)
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `example test 2`(){
        val list = listOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
        val result = Problem3.searchInRotatedArray(list, 15)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `example test 3`(){
        val list = listOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
        val result = Problem3.searchInRotatedArray(list, 14)
        assertThat(result).isEqualTo(11)
    }

    @Test
    fun `example test 4`(){
        val list = listOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
        val result = Problem3.searchInRotatedArray(list, 3)
        assertThat(result).isEqualTo(6)
    }


    @Test
    fun `not rotated array`(){
        val list = listOf(1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25)
        val result = Problem3.searchInRotatedArray(list, 10)
        assertThat(result).isEqualTo(5)
    }


    @Test
    fun `same array as example but rotated once more`(){
        val list = listOf(14, 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10)
        val result = Problem3.searchInRotatedArray(list, 5)
        assertThat(result).isEqualTo(9)
    }

}