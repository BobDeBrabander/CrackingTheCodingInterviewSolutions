package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem9GoogleDocTests {

    var listOfMultiples = listOf(1, 3, 5, 7, 9, 15, 21, 25, 27, 35, 45, 49)

    @Test
    fun `simple test`(){
        val k = 5
        val result = Problem9GoogleDoc.kthMultiple(k)
        assertThat(result).isEqualTo(listOfMultiples[k])
    }

    @Test
    fun `simple test 2`(){
        val k = 11
        val result = Problem9GoogleDoc.kthMultiple(k)
        assertThat(result).isEqualTo(listOfMultiples[k])
    }
}