package chapter16

object Problem11 {

    fun differentLengthsPossible(short: Int, long: Int, k: Int): Set<Int> {
        val differentConfigs = 1 shl k - 1
        val differentLengths = mutableSetOf<Int>()
        for (i in 0..differentConfigs) {
            val bitString = Integer.toBinaryString(i)
            var length = 0
            bitString.forEach {
                when (it) {
                    '0' -> length += short
                    '1' -> length += long
                }
            }
            differentLengths += length
        }
        return differentLengths.toSet()
    }
}