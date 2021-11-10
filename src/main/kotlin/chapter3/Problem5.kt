package chapter3

import java.util.Stack
import kotlin.math.max
import kotlin.math.min

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


    fun Stack<Int>.smartSort() : Stack<Int> {
        var tempStack = Stack<Int>()
        while(this.isNotEmpty()){
            var tmp = this.pop()
            while(tempStack.isNotEmpty() && tempStack.peek() > tmp){
                this.push(tempStack.pop())
            }
            tempStack.push(tmp)
        }

        while(tempStack.isNotEmpty()) {
            this.push(tempStack.pop())
        }
        return this
    }


    fun Stack<Int>.fastSort() : Stack<Int> {
        var tempStack = Stack<Int>()
        val runs = this.size

        var left = this.size + 1
        var biggest : Int? = null
        var biggestToQueue: Int? = null
        repeat(runs){ runNum ->
            if (runNum % 2 == 0) {
                biggest = this.biggestFromTop(min(left, this.size), biggest, tempStack)
                if (biggestToQueue != null) {
                    this.push(biggestToQueue)
                    biggestToQueue = null
                }
                this.push(biggest)
            } else {
                biggest = tempStack.biggestFromTop(tempStack.size, biggest, this)
                biggestToQueue = biggest
            }
            left--
        }
        return this
    }

    fun Stack<Int>.biggestFromTop(top: Int, skipValue: Int?, otherStack: Stack<Int>) : Int{
        var biggest = Int.MIN_VALUE
        var skipped = skipValue == null
        repeat(top){
            val value = this.pop()
            if (value == skipValue && !skipped) {
                skipped = true
            } else {
                biggest = max(biggest, value)
                otherStack.push(value)
            }
        }
        return biggest
    }
}