package chapter17

object Problem4 {

    class BitInt(private val num: Int){
        fun getBit(bitIndex: Int) : Int{
            return (num and (1 shl bitIndex)) ushr bitIndex
        }
    }

    fun missingNumber(list: List<BitInt>): Int {
        return missingNumber(list, 0)
    }

    private fun missingNumber(list: List<BitInt>, column: Int): Int {
        if (column >= 31) {
            return 0
        }
        val oneBits = mutableListOf<BitInt>()
        val zeroBits = mutableListOf<BitInt>()

        list.forEach {
            if (it.getBit(column) == 0) {
                zeroBits.add(it)
            } else {
                oneBits.add(it)
            }
        }
        return if (zeroBits.size <= oneBits.size) {
            val v = missingNumber(zeroBits, column+1)
            (v shl 1) or 0 //Last bit is 0, v will be the other bits behind it
        } else {
            val v = missingNumber(oneBits, column+1)
            (v shl 1) or 1 //Last bit is 1, v will be the other bits behind it
        }
    }
}