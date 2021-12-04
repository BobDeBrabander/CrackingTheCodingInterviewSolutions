package chapter8

object Problem5 {

    //num1 and num2 are given to be positive
    fun recursiveMultiply(num1: Int, num2: Int) : Int{
        if (num2 == 1) return num1
        var shifts = 1
        while (1 shl (shifts + 1) <= num2) {
            shifts++
        }
        return (num1 shl shifts) + recursiveMultiply(num1, num2 - (1 shl shifts))
    }
}