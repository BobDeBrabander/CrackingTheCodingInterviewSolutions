package chapter16

import kotlin.random.Random

object Problem23 {

    fun rand7fromRand5(): Int {
        var value = 5 * rand5() + rand5()
        while (value >= 21) value = 5 * rand5() + rand5()
        return value % 7
    }

    private fun rand5() = Random.nextInt(5)
}