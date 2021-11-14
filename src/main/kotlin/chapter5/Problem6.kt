package chapter5

object Problem6 {

    //How many bits would have to be flipped to turn A into B
    fun solve(A: Int, B: Int) : Int{
        //Create a mask that has 0's from i to j
        val bitsToFlip = A xor B
        var count = 0
        for (i in 0..31) if ((1 shl i) and bitsToFlip != 0) count++
        return count
    }
}