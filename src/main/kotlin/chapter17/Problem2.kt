package chapter17

import kotlin.random.Random

object Problem2 {

    //I'm shuffling integers instead of cards. There are 52 unique cards anyways so it's the same problem.
    fun shuffleDeck(cards: List<Int>): List<Int> {
        val deckCopy = cards.toMutableList()
        val shuffledDeck = mutableListOf<Int>()
        for (i in 52 downTo 1) {
            val rand = Random.nextInt(i)
            shuffledDeck.add(deckCopy.removeAt(rand))
        }
        return shuffledDeck
    }
}