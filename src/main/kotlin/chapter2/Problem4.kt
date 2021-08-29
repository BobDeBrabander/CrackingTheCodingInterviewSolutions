package chapter2

import mydatastructures.MySinglyLinkedList

object Problem4 {

    fun partitionAround(ll: MySinglyLinkedList<Int>, partition: Int): MySinglyLinkedList.Node<Int>?{
        var curNode = ll.head
        var head : MySinglyLinkedList.Node<Int>? = null
        var tail : MySinglyLinkedList.Node<Int>? = null
        while (curNode != null){
            val newNode = MySinglyLinkedList.Node<Int>(curNode.value)
            if (curNode.value!! < partition){
                newNode.next = head
                head = newNode
            } else {
                tail?.next = newNode
            }
            curNode = curNode.next
        }
        return head
    }
}