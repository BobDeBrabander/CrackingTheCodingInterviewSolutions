package chapter16

import kotlin.math.abs

object Problem8 {

    fun englishInt(n: Int) : String{
        if (n < 0) return "Negative " + englishInt(-1*n)
        if (n < 20) return englishUpto20(n)

        var result = ""
        var num = abs(n)
        val billions = num / 1000000000
        num %= 1000000000
        val millions = num / 1000000
        num %= 1000000
        val thousands = num / 1000
        num %= 1000


        if (billions > 0) result += englishUpto1000(billions) + "Billion "
        if (millions > 0) result += englishUpto1000(millions) + "Million "
        if (thousands > 0) result += englishUpto1000(thousands) + "Thousand "
        if (num > 0) result += englishUpto1000(num)
        return result.trimEnd()
    }

    private fun englishUpto1000(n: Int) : String {
        if (n < 20) return englishUpto20(n)

        var num = n
        val hundred = num/100
        num %= 100
        val tens = num/10
        num %= 10

        var answer = ""
        if (hundred > 0) answer += englishUpto20(hundred) + "Hundred "
        if (tens > 0) answer += englishMultiplesOf10(tens)
        if (num > 0) answer += englishUpto20(num)
        return answer
    }

    private fun englishMultiplesOf10(n: Int) : String{
        return when(n){
            1 -> "Ten "
            2 -> "Twenty "
            3 -> "Thirty "
            4 -> "Forty "
            5 -> "Fifty "
            6 -> "Sixty "
            7 -> "Seventy "
            8 -> "Eighty "
            else -> "Ninety "
        }
    }

    var smalls = listOf("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen")
    private fun englishUpto20(n: Int) : String = smalls[n]
}