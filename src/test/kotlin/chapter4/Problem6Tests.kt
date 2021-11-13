package chapter4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class Problem6Tests {

    //Copied from problem 2 for helping with easy testing
    //Sorted list into binary search tree
    fun List<Int>.toBinaryTree(): Problem6.BinaryTree {
        return this.toBinaryTree(1, 0, this.size - 1)
    }

    private fun List<Int>.toBinaryTree(depth: Int, start: Int, endIncl: Int): Problem6.BinaryTree {
        val numNodes = endIncl - start + 1
        val depthTree = kotlin.math.ceil(kotlin.math.log2((numNodes + 1).toDouble())).toInt()
        val fullTree = (1 shl depthTree) - 1
        val fullSubtreeSize = (fullTree - 1) / 2

        val mid = if (fullSubtreeSize == 0) start else start + fullSubtreeSize
        val beforeMid = mid - 1
        val afterMid = mid + 1

        var thisNode = Problem6.BinaryTreeNode(this[mid], depth)
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
        return Problem6.BinaryTree().apply { this.root = thisNode }
    }

    @Test
    fun `Check if successor call works`() {
        val valuesTreeWalkOrder = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val tree = valuesTreeWalkOrder.toBinaryTree()
        tree.root?.treeWalkCheck()
    }

    private fun Problem6.BinaryTreeNode.treeWalkCheck() {
        this.leftChild?.treeWalkCheck()
        val successor = this.successor()
        if (data == 10) assertNull(successor)
        else assertEquals(data + 1, successor?.data)
        this.rightChild?.treeWalkCheck()
    }
}