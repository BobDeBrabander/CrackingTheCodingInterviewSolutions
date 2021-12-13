package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem7Tests {

    @Test
    fun `example test`() {
        val frequencyMap = mapOf("John" to 15, "Jon" to 12, "Johnny" to 4, "Chris" to 13, "Kris" to 4, "Christopher" to 19)
        val synonyms = listOf("Jon" to "John", "John" to "Johnny", "Chris" to "Kris", "Chris" to "Christopher")
        val result = Problem7.babyNames(frequencyMap, synonyms)
        val expect = mapOf("Jon" to 31, "Chris" to 36)
        assertThat(result).isEqualTo(expect)
    }
}