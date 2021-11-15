package chapter5

object Problem4 {
    //Assumption: This number is not so big that a next number with the same amount of 1's doesn't exist
    //Given: Input integer is positive

    //If you add a 1 where there is a 0, it changes the number of 1's

    //If you add a 1 on the first position you see with a 1 with a 0 behind it
    //You create the smallest increase that leads to the same amount of 1's
    fun nextSmallestSame1s(A: Int) : Int{
        for (i in 1..30) {
            if (getBit(A, i) == 0 && getBit(A, i-1) != 0) {
                return A + (1 shl i-1)
            }
        }
        throw Exception("No such number exists")
    }

    //If you do this for all the 1's with a 0 behind it you get the biggest increase that leads to the same
    //amount of 1's
    fun nextBiggestSame1s(A: Int) : Int{
        var number = A
        for (i in 1..30) {
            if (getBit(A, i) == 0 && getBit(A, i-1) != 0) {
                number += (1 shl i-1)
            }
        }
        if (number == A) throw Exception("No such number exists")
        return number
    }

    fun getBit(A: Int, i: Int) : Int{
        return (1 shl i) and A
    }
}