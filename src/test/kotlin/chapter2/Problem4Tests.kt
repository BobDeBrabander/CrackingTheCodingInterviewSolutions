package chapter2

import chapter2.Problem4.partitionAround
import mydatastructures.MySinglyLinkedList
import org.junit.Test
import kotlin.test.fail

class Problem4Tests {

    @Test
    fun `simple test`() {
        val ll = MySinglyLinkedList<Int>()
        ll.addAll(listOf(3, 5, 8, 5, 10, 2, 1))
        handleTestCase(5, ll)
    }

    private fun handleTestCase(partition: Int, ll: MySinglyLinkedList<Int>) {
        val output = partitionAround(ll, partition)
        var node = output.head
        var seenPartition = false
        while (true) {
            when {
                (node?.value!! > partition) || (node?.value!! < partition && !seenPartition) -> node = node.next
                (node?.value!! == partition) -> seenPartition = true
                (node?.value!! < partition && seenPartition) -> fail("since we have seen the partition element we shouldn't see elements smaller than the partition anymore")
            }
        }
    }
}