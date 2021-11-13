package chapter4

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem5Tests {

    //Copied from problem 2 for helping with easy testing
    //Sorted list into binary search tree
    fun List<Int>.toBinaryTree(): Problem5.BinaryTree {
        return this.toBinaryTree(1, 0, this.size - 1)
    }

    private fun List<Int>.toBinaryTree(depth: Int, start: Int, endIncl: Int): Problem5.BinaryTree {
        val numNodes = endIncl - start + 1
        val depthTree = kotlin.math.ceil(kotlin.math.log2((numNodes + 1).toDouble())).toInt()
        val fullTree = (1 shl depthTree) - 1
        val fullSubtreeSize = (fullTree - 1) / 2

        val mid = if (fullSubtreeSize == 0) start else start + fullSubtreeSize
        val beforeMid = mid - 1
        val afterMid = mid + 1

        var thisNode = Problem5.BinaryTreeNode(this[mid], depth)
        if (beforeMid >= start) {
            var leftTree = this.toBinaryTree(depth + 1, start, beforeMid)
            thisNode.leftChild = leftTree.root
            leftTree.root?.parent = thisNode

        }
        if (afterMid <= endIncl) {
            var rightTree = this.toBinaryTree(depth + 1, afterMid, endIncl)
            thisNode.rightChild = rightTree.root
            rightTree.root?.parent = thisNode
        }
        return Problem5.BinaryTree().apply { this.root = thisNode }
    }

    @Test
    fun `Tree is BinarySearchTree`() {
        val valuesTreeWalkOrder = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val tree = valuesTreeWalkOrder.toBinaryTree()
        assertTrue(tree.isBST())
    }

    @Test
    fun `Tree is not BinarySearchTree`() {
        val valuesTreeWalkOrder = listOf(1, 2, 4, 3, 5, 6, 7, 8, 9, 10)
        val tree = valuesTreeWalkOrder.toBinaryTree()
        assertFalse(tree.isBST())
    }
}