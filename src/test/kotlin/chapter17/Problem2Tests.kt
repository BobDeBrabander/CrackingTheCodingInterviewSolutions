package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem2Tests {

    @Test
    fun `simple test`() {
        val deck = (1..52).toList()
        val shuffledDeck = Problem2.shuffleDeck(deck)
        assertThat(shuffledDeck).containsExactlyInAnyOrderElementsOf(deck)
        assertThat(shuffledDeck).isNotEqualTo(deck) //Technically it could shuffle exactly the same order as a normal deck
        //But this is astronomically rare
    }
}