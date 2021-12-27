package chapter17

import java.util.PriorityQueue
import kotlin.math.min

object Problem9GoogleDoc {
    fun kthMultiple(k: Int) : Int {
        if (k < 0) return -1
        var curValue = 1
        val q3 = PriorityQueue<Int>()
        val q5 = PriorityQueue<Int>()
        val q7 = PriorityQueue<Int>()
        q3.add(3)
        q5.add(5)
        q7.add(7)

        repeat(k){
            val q3val = q3.firstOrNull() ?: Integer.MAX_VALUE
            val q5val = q5.firstOrNull() ?: Integer.MAX_VALUE
            val q7val = q7.firstOrNull() ?: Integer.MAX_VALUE
            curValue = min(q3val, min(q5val, q7val))
            when (curValue) {
                q3val -> {
                    q3.poll()
                    q3.add(curValue*3)
                    q5.add(curValue*5)
                    q7.add(curValue*7)
                }
                q5val -> {
                    q5.poll()
                    q5.add(curValue*5)
                    q7.add(curValue*7)
                }
                q7val -> {
                    q7.poll()
                    q7.add(curValue*7)
                }
            }
        }
        return curValue
    }
}