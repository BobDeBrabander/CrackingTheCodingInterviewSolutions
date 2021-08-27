package chapter2

import mydatastructures.MySinglyLinkedList

object Problem2 {

    fun MySinglyLinkedList<Int>.kthToLast(k: Int) : MySinglyLinkedList.Node<Int>? {
        val lastIndex = this.getSize() - 1
        val indexToGo = lastIndex - k
        var curIndex = 0
        var curNode = this.head
        while(curIndex < indexToGo) {
            curNode = curNode?.next
            curIndex++
        }
        return curNode
    }

    fun MySinglyLinkedList<Int>.kthToLastWithoutSize(k: Int) : MySinglyLinkedList.Node<Int>? {
        var curNode = this.head
        var curNode2 = this.head
        repeat(k){
            curNode = curNode?.next
        }
        while(curNode?.next != null) {
            curNode = curNode?.next
            curNode2 = curNode2?.next
        }
        return curNode2
    }
}