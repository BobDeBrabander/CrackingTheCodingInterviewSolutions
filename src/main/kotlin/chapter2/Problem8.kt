package chapter2

import mydatastructures.MySinglyLinkedList

object Problem8 {

    fun findStartLoop(headll: MySinglyLinkedList.Node<Char>): MySinglyLinkedList.Node<Char>? {
        var node : MySinglyLinkedList.Node<Char>? = headll
        val seen = HashSet<MySinglyLinkedList.Node<Char>>()
        while(node != null){
            if (seen.contains(node)) return node
            seen.add(node)
            node = node.next
        }
        return null
    }
}