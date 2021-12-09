package chapter16

object Problem7 {

    fun maxNumberOf(num1: Int, num2: Int): Int {
        return ((num1 - num2) ushr 31) * num2 + ((num2 - num1) ushr 31) * num1
    }
}