package chapter17

object Problem4 {

    class BitList(private val list: List<Int>) {
        fun getBitOfNum(numIndex: Int, bitIndex: Int): Int {
            return (list[numIndex] and (1 shl bitIndex)) ushr bitIndex
        }

        fun size(): Int {
            return list.size
        }
    }

    fun missingNumber(list: BitList, n: Int): Int {
        var numsFound = MutableList(n) { false }
        repeat(n - 1) { index ->
            var bit = 0
            var curNum = 0
            while (1 shl bit <= n) {
                val bitFound = list.getBitOfNum(index, bit)
                if (bitFound == 1) curNum += (1 shl bit)
                bit++
            }
            numsFound[curNum] = true
        }
        repeat(n){
            if (!numsFound[it]) return it
        }
        return -1
    }
}