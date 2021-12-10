package chapter16

import java.lang.IllegalArgumentException
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

object Problem9 {

    fun subtract(a: Int, b: Int): Int {
        val mask = -1
        return a + ((b xor mask) + 1)
    }

    fun multiply(a: Int, b: Int): Int {
        if (a == 0 || b == 0) return 0
        val positive = (a < 0 && b < 0) || (a > 0 && b > 0)
        val absA = abs(a)
        val absB = abs(b)
        val ans = multiplyPositive(max(absA, absB), min(absA, absB))
        return if (positive){
            ans
        } else {
            subtract(0, ans)
        }
    }

    private fun multiplyPositive(bigger: Int, smaller: Int) : Int{
        if (smaller == 0) return 0
        else if (smaller == 1) return bigger

        val s = smaller shr 1
        val halfProd = multiplyPositive(bigger, s)
        return if (smaller % 2 == 0) halfProd + halfProd
        else halfProd + halfProd + bigger
    }

    fun divide(a: Int, b: Int): Int {
        if (b == 0) throw IllegalArgumentException("Can't divide by 0")
        if (a == 0) return 0
        val positive = (a < 0 && b < 0) || (a > 0 && b > 0)
        val absA = abs(a)
        val absB = abs(b)
        val ans = dividePositive(absA, absB)
        return if (positive){
            ans
        } else {
            subtract(0, ans)
        }
    }

    private fun dividePositive(a: Int, b: Int) : Int{
        if (a < b) return 0
        if (b == 1) return a
        if (b == 2) return a shr 1
        //a/b = a-b/b + 1
        return if (b % 2 == 1) 1 + dividePositive(subtract(a, b), b)
        else {
            val newB = b shr 1
            //a/b = (a/(b/2)) * (1/2)
            dividePositive(a, newB) shr 1
        }
    }
}