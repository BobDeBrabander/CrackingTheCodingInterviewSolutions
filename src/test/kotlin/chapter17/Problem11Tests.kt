package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem11Tests {

    @Test
    fun `simple test`(){
        val wordList = listOf("kaas", "fred", "friet", "hond", "henk", "piet", "friet", "doei", "fred")
        val wordDistanceLookup = Problem11.WordDistanceLookup(wordList)

        val query1 = wordDistanceLookup.minDistance("kaas", "henk")
        val exp1 = 4
        assertThat(query1).isEqualTo(exp1)

        val query2 = wordDistanceLookup.minDistance("kaas", "fred")
        val exp2 = 1
        assertThat(query2).isEqualTo(exp2)

        val query3 = wordDistanceLookup.minDistance("friet", "fred")
        val exp3 = 1
        assertThat(query3).isEqualTo(exp3)

        val query4 = wordDistanceLookup.minDistance("fred", "henk")
        val exp4 = 3
        assertThat(query4).isEqualTo(exp4)

        val query5 = wordDistanceLookup.minDistance("fred", "piet")
        val exp5 = 3
        assertThat(query5).isEqualTo(exp5)
    }
}