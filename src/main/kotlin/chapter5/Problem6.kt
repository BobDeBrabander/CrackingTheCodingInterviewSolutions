package chapter5

object Problem6 {

    //How many bits would have to be flipped to turn A into B
    fun solve(A: Int, B: Int) : Int{
        //Create a mask that has 0's from i to j
        var bitsToFlip = A xor B
        var count = 0
        while (bitsToFlip != 0){
            count++
            bitsToFlip = bitsToFlip and (bitsToFlip - 1) //clear least significant bit
        }
        return count
    }
}