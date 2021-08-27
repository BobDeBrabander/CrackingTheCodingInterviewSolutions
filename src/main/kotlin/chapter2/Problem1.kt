package chapter2

import mydatastructures.MyDoublyLinkedList

object Problem1 {

    fun MyDoublyLinkedList<Int>.removeDuplicates() : MyDoublyLinkedList<Int>{
        val seen = HashSet<Int>()
        var curr = this.head
        while(curr?.value != null){
            if (seen.contains(curr.value)) {
                val next = curr.next
                this.unlink(curr)
                curr = next
                continue
            }
            else seen.add(curr.value!!)
            curr = curr.next
        }
        return this
    }
}