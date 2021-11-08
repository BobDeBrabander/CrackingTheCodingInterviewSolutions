package chapter3

import kotlin.math.min

object Problem2 {

    class SpecialStack(){

        class SpecialStackNode(val data: Int, val curMin: Int){
            var next: SpecialStackNode? = null
        }
        private var top: SpecialStackNode? = null

        fun push(data: Int){
            val newMin = top?.data?.let { min(it, data) } ?: data
            val newNode = SpecialStackNode(data, newMin)
            newNode.next = top
            top = newNode
        }

        fun pop() : Int{
            val returnVal = top?.data ?: throw NoSuchElementException()
            top = top?.next
            return returnVal
        }

        fun min() : Int{
            return top?.curMin ?: throw NoSuchElementException()
        }
    }
}