package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem10Tests {

    @Test
    fun `simple test`(){
        val people = listOf(
            Problem10.Person(1900, 1904),
            Problem10.Person(1904, 1910),
            Problem10.Person(1910, 1950),
            Problem10.Person(1920, 1935),
            Problem10.Person(1935, 1935),
            Problem10.Person(1935, 1936),
        )

        val result = Problem10.yearMostPeopleAlive(people)
        val expect = 1935
        assertThat(result).isEqualTo(expect)
    }
}