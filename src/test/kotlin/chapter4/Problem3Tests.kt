package chapter4

import org.junit.Test
import kotlin.test.assertEquals

class Problem3Tests {

    @Test
    fun `Testing implementation`(){
        val binarySearchTree = Problem3.BinaryTree()
        val root = Problem3.BinaryTreeNode(1, 1)
        binarySearchTree.root = root

        val left = Problem3.BinaryTreeNode(2, 2)
        val right = Problem3.BinaryTreeNode(3, 2)
        root.leftChild = left
        root.rightChild = right

        val leftLeft = Problem3.BinaryTreeNode(4, 3)
        val leftRight = Problem3.BinaryTreeNode(5, 3)
        left.leftChild = leftLeft
        left.rightChild = leftRight
        val rightLeft = Problem3.BinaryTreeNode(6, 3)
        val rightRight = Problem3.BinaryTreeNode(7, 3)
        right.leftChild = rightLeft
        right.rightChild = rightRight

        val leftLeftLeft = Problem3.BinaryTreeNode(8, 4)
        val leftLeftRight = Problem3.BinaryTreeNode(9, 4)
        leftLeft.leftChild = leftLeftLeft
        leftLeft.rightChild = leftLeftRight
        val leftRightLeft = Problem3.BinaryTreeNode(10, 4)
        val leftRightRight = Problem3.BinaryTreeNode(11, 4)
        leftRight.leftChild = leftRightLeft
        leftRight.rightChild = leftRightRight
        val rightLeftLeft = Problem3.BinaryTreeNode(12, 4)
        val rightLeftRight = Problem3.BinaryTreeNode(13, 4)
        rightLeft.leftChild = rightLeftLeft
        rightLeft.rightChild = rightLeftRight
        val rightRightLeft = Problem3.BinaryTreeNode(14, 4)
        val rightRightRight = Problem3.BinaryTreeNode(15, 4)
        rightRight.leftChild = rightRightLeft
        rightRight.rightChild = rightRightRight

        val lists = binarySearchTree.toLinkedLists()
        assertEquals(listOf(1), lists[0].toList())
        assertEquals(listOf(2, 3), lists[1].toList())
        assertEquals(listOf(4, 5, 6, 7), lists[2].toList())
        assertEquals(listOf(8, 9, 10, 11, 12, 13, 14, 15), lists[3].toList())
    }
}