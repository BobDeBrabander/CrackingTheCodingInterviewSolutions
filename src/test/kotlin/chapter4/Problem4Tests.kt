package chapter4

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem4Tests {

    @Test
    fun `balanced tree`() {
        val binaryTree = Problem4.BinaryTree()
        val root = Problem4.BinaryTreeNode(1, 1)
        binaryTree.root = root

        val left = Problem4.BinaryTreeNode(2, 2)
        val right = Problem4.BinaryTreeNode(3, 2)
        root.leftChild = left
        root.rightChild = right

        val leftLeft = Problem4.BinaryTreeNode(4, 3)
        val leftRight = Problem4.BinaryTreeNode(5, 3)
        left.leftChild = leftLeft
        left.rightChild = leftRight
        val rightLeft = Problem4.BinaryTreeNode(6, 3)
        val rightRight = Problem4.BinaryTreeNode(7, 3)
        right.leftChild = rightLeft
        right.rightChild = rightRight

        val leftLeftLeft = Problem4.BinaryTreeNode(8, 4)
        val leftLeftRight = Problem4.BinaryTreeNode(9, 4)
        leftLeft.leftChild = leftLeftLeft
        leftLeft.rightChild = leftLeftRight
        val leftRightLeft = Problem4.BinaryTreeNode(10, 4)
        val leftRightRight = Problem4.BinaryTreeNode(11, 4)
        leftRight.leftChild = leftRightLeft
        leftRight.rightChild = leftRightRight

        //                    1
        //             2               3
        //          4     5         6      7
        //        8  9  10  11
        assertTrue(binaryTree.isBalanced())
    }

    @Test
    fun `unbalanced tree`() {
        val binaryTree = Problem4.BinaryTree()
        val root = Problem4.BinaryTreeNode(1, 1)
        binaryTree.root = root

        val left = Problem4.BinaryTreeNode(2, 2)
        root.leftChild = left

        val leftleft = Problem4.BinaryTreeNode(3, 3)
        left.leftChild = leftleft

        assertFalse(binaryTree.isBalanced())
    }

    @Test
    fun `balanced tree small`() {
        val binaryTree = Problem4.BinaryTree()
        val root = Problem4.BinaryTreeNode(1, 1)
        binaryTree.root = root

        val left = Problem4.BinaryTreeNode(2, 2)
        root.leftChild = left
        assertTrue(binaryTree.isBalanced())
    }

    @Test
    fun `balanced tree only root`() {
        val binaryTree = Problem4.BinaryTree()
        val root = Problem4.BinaryTreeNode(1, 1)
        binaryTree.root = root

        assertTrue(binaryTree.isBalanced())
    }
}