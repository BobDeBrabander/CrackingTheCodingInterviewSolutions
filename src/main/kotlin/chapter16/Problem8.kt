package chapter16

object Problem8 {

    fun englishInt(n: Int) : String{
        if (n == 0) return "Zero"
        if (n == 11) return "Eleven"
        if (n == 12) return "Twelve"
        if (n == 13) return "Thirteen"
        if (n == 14) return "Fourteen"
        if (n == 15) return "Fifteen"
        if (n == 16) return "Sixteen"
        if (n == 17) return "Seventeen"
        if (n == 18) return "Eighteen"
        if (n == 19) return "Nineteen"

        var num = n
        val billions = num / 1000000000
        num %= 1000000000
        val millions = num / 1000000
        num %= 1000000
        val thousands = num / 1000
        num %= 1000

        var result = ""
        if (billions > 0) result += englishUpto1000(billions) + "Billion "
        if (millions > 0) result += englishUpto1000(millions) + "Million "
        if (thousands > 0) result += englishUpto1000(thousands) + "Thousand "
        if (num > 0) result += englishUpto1000(num)
        return result.trimEnd()
    }

    private fun englishUpto1000(n: Int) : String {
        if (n == 11) return "Eleven "
        if (n == 12) return "Twelve "
        if (n == 13) return "Thirteen "
        if (n == 14) return "Fourteen "
        if (n == 15) return "Fifteen "
        if (n == 16) return "Sixteen "
        if (n == 17) return "Seventeen "
        if (n == 18) return "Eighteen "
        if (n == 19) return "Nineteen "

        var num = n
        val hundred = num/100
        num %= 100
        val tens = num/10
        num %= 10

        var answer = ""
        if (hundred > 0) answer += englishUpto10(hundred) + "Hundred "
        if (tens > 0) answer += englishMultiplesOf10(tens)
        if (num > 0) answer += englishUpto10(num)
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

    private fun englishUpto10(n: Int) : String{
        return when(n){
            1 -> "One "
            2 -> "Two "
            3 -> "Three "
            4 -> "Four "
            5 -> "Five "
            6 -> "Six "
            7 -> "Seven "
            8 -> "Eight "
            else -> "Nine "
        }
    }
}