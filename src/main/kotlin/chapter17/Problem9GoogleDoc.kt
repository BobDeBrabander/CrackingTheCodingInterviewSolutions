package chapter17

import kotlin.math.min

object Problem9GoogleDoc {
    fun kthMultiple(k: Int): Int {
        if (k < 0) return -1
        var curValue = 1
        val q3 = ArrayDeque<Int>()
        val q5 = ArrayDeque<Int>()
        val q7 = ArrayDeque<Int>()
        q3.add(3)
        q5.add(5)
        q7.add(7)

        repeat(k) {
            val q3val = q3.firstOrNull() ?: Integer.MAX_VALUE
            val q5val = q5.firstOrNull() ?: Integer.MAX_VALUE
            val q7val = q7.firstOrNull() ?: Integer.MAX_VALUE
            curValue = min(q3val, min(q5val, q7val))
            when (curValue) {
                q3val -> {
                    q3.removeFirst()
                    q3.addLast(curValue * 3)
                    q5.addLast(curValue * 5)
                    q7.addLast(curValue * 7)
                }
                q5val -> {
                    q5.removeFirst()
                    q5.addLast(curValue * 5)
                    q7.addLast(curValue * 7)
                }
                q7val -> {
                    q7.removeFirst()
                    q7.addLast(curValue * 7)
                }
            }
        }
        return curValue
    }
}