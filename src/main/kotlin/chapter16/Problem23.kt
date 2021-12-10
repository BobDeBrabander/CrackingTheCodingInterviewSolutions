package chapter16

import kotlin.random.Random

object Problem23 {

    fun rand7fromRand5(): Int {
        var value = rand8fromRand2()
        while (value == 7) value = rand8fromRand2()
        return value
    }

    private fun rand8fromRand2(): Int {
        var b0 = rand2FromRand5()
        var b1 = rand2FromRand5()
        var b2 = rand2FromRand5()
        return b0 + b1 * 2 + b2 * 4
    }

    private fun rand2FromRand5(): Int {
        var roll = rand5()
        while (roll == 2) roll = rand5()
        return if (roll > 2) 1 else 0
    }

    private fun rand5() = Random.nextInt(5)
}