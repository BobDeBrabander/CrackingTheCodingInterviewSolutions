package chapter2

import mydatastructures.MySinglyLinkedList
import kotlin.math.abs

object Problem7 {

    fun findIntersection(headll1: MySinglyLinkedList.Node<Int>, headll2: MySinglyLinkedList.Node<Int>): MySinglyLinkedList.Node<Int>? {
        if (tail(headll1) != tail(headll2)) return null

        val l1 = length(headll1)
        val l2 = length(headll2)
        val diff = abs(l1 - l2)

        var cur1 : MySinglyLinkedList.Node<Int>? = headll1
        var cur2 : MySinglyLinkedList.Node<Int>?  = headll2
        if (l1 > l2){
            repeat(diff) { cur1 = cur1?.next }
        } else {
            repeat(diff) { cur2 = cur2?.next }
        }

        while(cur1 != cur2){
            cur1 = cur1?.next
            cur2 = cur2?.next
        }
        return cur1
    }

    fun length(node: MySinglyLinkedList.Node<Int>?) : Int{
        var count = 0
        var curNode = node
        while (curNode != null){
            count++
            curNode = curNode.next
        }
        return count
    }

    fun tail(node: MySinglyLinkedList.Node<Int>) : MySinglyLinkedList.Node<Int>{
        var curNode = node
        while (curNode.next != null){
            curNode = curNode.next!!
        }
        return curNode
    }

}