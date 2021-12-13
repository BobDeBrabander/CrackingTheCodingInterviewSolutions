package chapter17

object Problem6 {

    fun count2s(n: Int): Int {
        if (n < 2) return 0
        var pow = 1
        while (pow * 10 <= n) pow *= 10
        val div = n / pow
        var ans = count2s(pow - 1) * div + count2s(n % pow)
        when (div) {
            2 -> ans += (n % pow) + 1
            in 3..9 -> ans += pow
        }
        return ans
    }
}