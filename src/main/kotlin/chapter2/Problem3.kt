package chapter2

import mydatastructures.MySinglyLinkedList

private fun MySinglyLinkedList.Node<Any>.delete(){
    if (this.next == null) return //It is not a middle node
    //copy values of next node and let the next node drop out
    //previous node is still connected to us so chain is not broken
    this.value = this.next?.value
    this.next = this.next?.next
}