package chapter16

object Problem7 {

    fun maxNumberOf(num1: Int, num2: Int): Int {
        val c = num1 - num2

        val s1 = sign(num1) //if num1 >= 0 then 1 else 0
        val s2 = sign(num2) //if num2 >= 0 then 1 else 0
        val sc = sign(c)    //if num1 - num2 does not overflow: if num2 bigger than num1 1 else 0

        //use s1
        val useS1 = s1 xor s2 //if we num1 and num2 have different signs 1 else 0
        val useSC = flip(s1 xor s2) //if num1 and num2 have same sign 1 else 0

        //if num1 and num2 have the same signs k = sc else k = s1
        val k = useS1 * s1 + useSC * sc
        val q = flip(k)

        return k * num2 + q * num1
    }

    fun sign(num: Int): Int {
        return num ushr 31
    }

    fun flip(num: Int): Int {
        return num xor 1
    }
}