package chapter7.problem1

sealed interface CardValue{
    class SingleValue(val value: Int) : CardValue
    class MultipleValue(val values: List<Int>) : CardValue
}