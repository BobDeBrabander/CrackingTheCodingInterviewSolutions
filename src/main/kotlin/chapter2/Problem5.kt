package chapter2

import mydatastructures.MySinglyLinkedList
import kotlin.math.max

object Problem5 {
    fun sumListsForward(ll1: MySinglyLinkedList<Int>, ll2: MySinglyLinkedList<Int>) : MySinglyLinkedList<Int>{
        var cur1 = ll1.head
        var cur2 = ll2.head
        var output = MySinglyLinkedList<Int>()

        var takeOver = 0
        while(cur1 != null || cur2 != null){
            val totalValue = (cur1?.value ?: 0) + (cur2?.value ?: 0) + takeOver
            takeOver = if (totalValue >= 10) 1 else 0
            val value = if (totalValue >= 10) totalValue - 10 else totalValue
            output.add(value)
            if (cur1 != null) cur1 = cur1.next
            if (cur2 != null) cur2 = cur2.next
        }
        if (takeOver != 0) output.add(takeOver)
        return output
    }


    /**
     * ---------------- BACKWARDS -----------------------------
     */

    fun sumListsBackwards(ll1: MySinglyLinkedList<Int>, ll2: MySinglyLinkedList<Int>) : MySinglyLinkedList.Node<Int> {
        val bigSize = max(ll1.getSize(), ll2.getSize())
        var ll1Head = ll1.head
        var ll2Head = ll2.head

        repeat(bigSize - ll1.getSize()){ ll1Head = prependZero(ll1)}
        repeat(bigSize - ll2.getSize()){ ll2Head = prependZero(ll2)}

        val sum = addListHelper(ll1Head, ll2Head)
        return if (sum.carry == 1){
            val node = MySinglyLinkedList.Node<Int>(1)
            node.next = sum.node
            node
        } else {
           sum.node!!
        }
    }

    data class SumHelper(val node: MySinglyLinkedList.Node<Int>?, val carry: Int)

    fun addListHelper(node1: MySinglyLinkedList.Node<Int>?, node2: MySinglyLinkedList.Node<Int>?) : SumHelper{
        if (node1 == null && node2 == null) return SumHelper(null, 0)

        val sumNext = addListHelper(node1?.next, node2?.next)
        val sum = sumNext.carry + (node1?.value ?: 0) + (node2?.value ?: 0)
        val node = MySinglyLinkedList.Node(sum % 10)
        val carry = sum / 10
        return SumHelper(node, carry)
    }

    fun prependZero(ll: MySinglyLinkedList<Int>): MySinglyLinkedList.Node<Int> {
        val node = MySinglyLinkedList.Node(0)
        node.next = ll.head
        return node
    }
}