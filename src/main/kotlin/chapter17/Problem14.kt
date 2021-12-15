package chapter17

import java.util.Collections
import java.util.PriorityQueue

object Problem14 {

    fun smallestK(list: List<Int>, k: Int): List<Int> {
        val maxHeap = PriorityQueue<Int>(k, Collections.reverseOrder())
        list.forEach {
            if (maxHeap.size < k) maxHeap.add(it)
            else {
                if (maxHeap.peek() > it) {
                    maxHeap.poll()
                    maxHeap.add(it)
                }
            }
        }
        return maxHeap.toList()
    }
}