package chapter17

import kotlin.math.min

object Problem9 {

    fun kthMultiple(k: Int): Int {
        if (k < 0) return 0

        var min = 0
        val q3 = mutableListOf<Int>(1)
        val q5 = mutableListOf<Int>()
        val q7 = mutableListOf<Int>()
        repeat(k+1) {
            val v3 = q3.getOrNull(0) ?: Int.MAX_VALUE
            val v5 = q5.getOrNull(0) ?: Int.MAX_VALUE
            val v7 = q7.getOrNull(0) ?: Int.MAX_VALUE
            min = min(v3, min(v5, v7))
            when(min){
                v3 -> {
                    q3.removeAt(0)
                    q3.add(3*min)
                    q5.add(5*min)
                }
                v5 -> {
                    q5.removeAt(0)
                    q5.add(5*min)
                }
                v7 -> q7.removeAt(0)
            }
            q7.add(7*min)
        }
        return min
    }
}