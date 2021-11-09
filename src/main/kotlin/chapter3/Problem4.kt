package chapter3

import java.util.Stack

object Problem4 {

    class MyQueue() {

        var addStack = Stack<Int>()
        var removeStack = Stack<Int>()

        fun add(data: Int) {
            addStack.push(data)
        }

        fun remove(): Int {
            if (removeStack.isEmpty() && addStack.isEmpty()) throw NoSuchElementException()
            if (removeStack.isEmpty()) {
                while (addStack.isNotEmpty()) removeStack.add(addStack.pop())
            }
            return removeStack.pop()
        }

    }
}