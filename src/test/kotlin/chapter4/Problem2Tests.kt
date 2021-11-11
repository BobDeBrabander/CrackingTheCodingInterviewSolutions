package chapter4

import chapter4.Problem2.toBinarySearchTree
import org.junit.Test
import kotlin.test.assertEquals

class Problem2Tests {

    @Test
    fun `Testing construction of binary search tree from sorted list`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val tree = list.toBinarySearchTree()
        //height 3 -> max 7 nodes
        //height 4 -> max 15 nodes
        assertEquals(4, tree.height())
    }

    @Test
    fun `Edge case 1 - tree fits exactly in height`() {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        val tree = list.toBinarySearchTree()
        //height 4 -> max 15 nodes
        assertEquals(4, tree.height())
    }

    @Test
    fun `Edge case 2 - small tree`() {
        val list = listOf(1, 2)
        val tree = list.toBinarySearchTree()
        //height 2 -> max 3 nodes
        assertEquals(2, tree.height())
    }

    @Test
    fun `Edge case 3 - single element`() {
        val list = listOf(1)
        val tree = list.toBinarySearchTree()
        //height 1 -> max 1 nodes
        assertEquals(1, tree.height())
    }

}