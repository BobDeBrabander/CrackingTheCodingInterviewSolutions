package chapter17

object Problem1 {

    fun addWithoutPlus(num1: Int, num2: Int): Int {
        if (num2 == 0) return num1
        val sum = num1 xor num2
        val carry = (num1 and num2) shl 1
        return addWithoutPlus(sum, carry)
    }
}