package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem8Tests {

    @Test
    fun `example test`() {
        val num = 1234
        val expected = "One Thousand Two Hundred Thirty Four"
        val result = Problem8.englishInt(num)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `simple test`() {
        val num = 14
        val expected = "Fourteen"
        val result = Problem8.englishInt(num)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `simple test 2`() {
        val num = 14000
        val expected = "Fourteen Thousand"
        val result = Problem8.englishInt(num)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Complex test`() {
        val num = 2123456789
        val expected = "Two Billion One Hundred Twenty Three Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine"
        val result = Problem8.englishInt(num)
        assertThat(result).isEqualTo(expected)
    }
}