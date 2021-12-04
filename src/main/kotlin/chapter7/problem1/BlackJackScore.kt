package chapter7.problem1

sealed interface BlackJackScore{
    class Score(val Score: Int) : BlackJackScore
    class Dead(val Score: Int) : BlackJackScore
}