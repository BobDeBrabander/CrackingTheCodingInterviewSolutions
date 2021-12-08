package chapter10

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem4Tests {

    @Test
    fun `simple test 1`() {
        val list = listOf(1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25)
        val listy = Problem4.Listy(list)
        val result = Problem4.listySortedSearch(listy, 5)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `simple test 2`() {
        val list = listOf(1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25)
        val listy = Problem4.Listy(list)
        val result = Problem4.listySortedSearch(listy, 5)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `simple test element not found`() {
        val list = listOf(1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25)
        val listy = Problem4.Listy(list)
        val result = Problem4.listySortedSearch(listy, 8)
        assertThat(result).isEqualTo(-1)
    }

}