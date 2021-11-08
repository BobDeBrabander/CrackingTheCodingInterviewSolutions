package chapter3

import java.util.EmptyStackException

object Problem1 {

    class Stack3In1(stackNum: Int){
        var list: MutableList<Int> = MutableList(stackNum) { -1 }
        var indices = MutableList(stackNum) { index -> index }
        var sizes = MutableList(stackNum) { 0 }

        fun addToStack(stackNum: Int, element: Int){
            list[indices[stackNum]] = element
            indices[stackNum] += stackNum
            sizes[stackNum]++
        }

        fun popStack(stackNum: Int) : Int{
            if (sizes[stackNum] <= 0) throw EmptyStackException()
            val returnVal = list[indices[stackNum]]
            indices[stackNum] -= stackNum
            sizes[stackNum]--
            return returnVal
        }
    }

}