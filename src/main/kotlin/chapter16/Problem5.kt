package chapter16

import kotlin.math.min

object Problem5 {

    fun trailingZerosBehindFactorialOf(n: Int) : Int{
        var factors2 = 0
        var factors5 = 0
        repeat(n+1){
            var num = it
            while (num / 5 > 0 && num % 5 == 0) {
                factors5++
                num /= 5
            }
            while (num / 2 > 0 && num % 2 == 0) {
                factors2++
                num /= 2
            }
        }
        return min(factors5, factors2)
    }
}