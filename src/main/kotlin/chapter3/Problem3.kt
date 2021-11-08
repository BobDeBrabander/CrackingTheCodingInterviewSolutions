package chapter3

import java.util.Stack

object Problem3 {

    class SetOfStacks(val stackSizeLimit: Int){
        var stackIndex = 0
        var stacks = MutableList<Stack<Int>>(1) {Stack()}

        fun push(data: Int){
            if (stacks[stackIndex].size < stackSizeLimit) {
                stacks[stackIndex].push(data)
            } else {
                stackIndex++
                stacks[stackIndex] = Stack()
                stacks[stackIndex].push(data)
            }
        }

        fun pop(): Int{
            if (stacks[stackIndex].isEmpty() && stackIndex == 0) throw NoSuchElementException()
            else if (stacks[stackIndex].isEmpty()) stackIndex--
            return stacks[stackIndex].pop()
        }
    }
}