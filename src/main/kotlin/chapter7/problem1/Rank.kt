package chapter7.problem1


enum class Rank(val value: CardValue) {
    TWO(CardValue.SingleValue(2)),
    THREE(CardValue.SingleValue(3)),
    FOUR(CardValue.SingleValue(4)),
    FIVE(CardValue.SingleValue(5)),
    SIX(CardValue.SingleValue(6)),
    SEVEN(CardValue.SingleValue(7)),
    EIGHT(CardValue.SingleValue(8)),
    NINE(CardValue.SingleValue(9)),
    TEN(CardValue.SingleValue(10)),
    JACK(CardValue.SingleValue(10)),
    QUEEN(CardValue.SingleValue(10)),
    KING(CardValue.SingleValue(10)),
    ACE(CardValue.MultipleValue(listOf(1, 11)))
}