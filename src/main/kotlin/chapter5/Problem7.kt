package chapter5

object Problem7 {

    //Odd and even bits have to be swapped:
    //e.g. bit 0 and 1 are swapped, bit 2 and 3 are swapped an so on
    //As few instructions as possible
    fun pairWiseSwap(A: Int) : Int{
        val maskOddBits = 1431655765    //01010101010101010101010101010101
        val maskEvenBits = -1431655766  //10101010101010101010101010101010
        val oddBits = A and maskOddBits
        val evenBits = A and maskEvenBits
        return (oddBits shl 1) or (evenBits shr 1)
    }
}