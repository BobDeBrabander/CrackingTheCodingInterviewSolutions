package chapter2

import mydatastructures.MySinglyLinkedList

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

    fun sumListsBackwards(ll1: MySinglyLinkedList<Int>, ll2: MySinglyLinkedList<Int>) : MySinglyLinkedList<Int> {
        throw NotImplementedError()
    }
}