package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.test.assertTrue

class Problem7Tests {

    @Test
    fun `example test`() {
        val frequencyMap =
            mapOf("John" to 15, "Jon" to 12, "Johnny" to 4, "Chris" to 13, "Kris" to 4, "Christopher" to 19)
        val synonyms = listOf("Jon" to "John", "John" to "Johnny", "Chris" to "Kris", "Chris" to "Christopher")
        val result = Problem7.babyNames(frequencyMap, synonyms)

        assertTrue(
            (result.containsKey("Jon") && result["Jon"] == 31) ||
                    (result.containsKey("John") && result["John"] == 31) ||
                    (result.containsKey("Johnny") && result["Johnny"] == 31)
        )
        assertTrue(
            (result.containsKey("Kris") && result["Kris"] == 36) ||
                    (result.containsKey("Christopher") && result["Christopher"] == 36) ||
                    (result.containsKey("Chris") && result["Chris"] == 36)
        )
        assertThat(result).hasSize(2)
    }
}