package chapter16

object Problem11 {

    fun differentLengthsPossible(short: Int, long: Int, k: Int): Set<Int> {
        val differentLengths = mutableSetOf<Int>()
        for (i in 0..k) {
            differentLengths += i * short + (k - i) * long
        }
        return differentLengths.toSet()
    }
}