package chapter2

import mydatastructures.MySinglyLinkedList

object Problem6 {

    fun isPalindrome(ll: MySinglyLinkedList<Int>) : Boolean{
        var nodeRev : MySinglyLinkedList.Node<Int>? = null
        var curNode = ll.head
        while(curNode != null){
            var newNode = MySinglyLinkedList.Node(curNode.value)
            newNode.next = nodeRev
            nodeRev = newNode
            curNode = curNode.next
        }
        //At this point we should have one reversed version of the list starting with nodeRev
        var nodeNorm = ll.head
        while (nodeNorm != null && nodeRev != null){
            if (nodeNorm.value != nodeRev.value) return false
            nodeNorm = nodeNorm.next
            nodeRev = nodeRev.next
        }
        return true
    }
}