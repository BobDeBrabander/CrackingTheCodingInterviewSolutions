package chapter3

import java.util.Stack
import kotlin.math.max

object Problem5 {

    fun Stack<Int>.sort() : Stack<Int> {
        var tempStack = Stack<Int>()
        val runs = this.size

        var curRun = 0
        var biggest : Int = Int.MIN_VALUE
        repeat(runs){ runNum ->
            while(this.size > curRun) {
                val value = this.pop()
                tempStack.push(value)
                biggest = max(biggest, value)
            }
            this.push(biggest)

            var seen = false
            while(tempStack.isNotEmpty()){
                val value = tempStack.pop()
                if (value == biggest && !seen){
                    seen = true
                } else {
                    this.push(value)
                }
            }

            curRun++
            biggest = Int.MIN_VALUE
        }
        return this
    }
}