package chapter7.problem1

class Deck {

    private val allCards : List<Card> = Suit.values().map{ suit -> Rank.values().map { rank -> Card(rank, suit) }}.flatten()

    private val cards = ArrayDeque<Card>()

    fun drawCard() : Card{
        return cards.removeFirst()
    }

    fun resetDeck(){
        cards.clear()
        cards.addAll(allCards.toList())
        cards.shuffle()
    }
}