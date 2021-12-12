package chapter17

object Problem1 {

    fun addWithoutPlus(num1: Int, num2: Int): Int {
        var n1 = num1
        val n2 = num2
        val s2 = sign(n2)
        for (i in 30 downTo 0) {
            if (bitValue(n2, i) != s2){
                var j = i
                while (j < 31 && bitValue(n1, j) != s2) {
                    n1 = flipBit(n1, j)
                    j++
                }
                n1 = flipBit(n1, j)
            }
        }
        if (s2 == 1) { //If num2 is negative then 'add' one more 0
            var j = 0
            while (j < 31 && bitValue(n1, j) != s2) {
                n1 = flipBit(n1, j)
                j++
            }
            n1 = flipBit(n1, j)
        }
        return n1
    }

    fun bitValue(num: Int, bit: Int) : Int {
        return (num and (1 shl bit)) ushr bit
    }

    fun sign(num: Int): Int {
        return num ushr 31
    }

    fun flipBit(num: Int, bit: Int): Int {
        return num xor (1 shl bit)
    }
}