package chapter10

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem5Tests {

    @Test
    fun `example test`() {
        val list = listOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val result = Problem5.sparseSearch(list, "ball")
        val expect = 4
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `example test2`() {
        val list = listOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val result = Problem5.sparseSearch(list, "at")
        val expect = 0
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `example test3`() {
        val list = listOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val result = Problem5.sparseSearch(list, "car")
        val expect = 7
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `example test4`() {
        val list = listOf("at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "")
        val result = Problem5.sparseSearch(list, "dad")
        val expect = 10
        assertThat(result).isEqualTo(expect)
    }
}