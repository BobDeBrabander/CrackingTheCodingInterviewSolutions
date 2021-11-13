package chapter4

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem10Tests {

    @Test
    fun `Subtree test`() {
        assertTrue(bigBinaryTree().containsSubTree(smallerBinarySubTree()))
    }

    @Test
    fun `Non-Subtree test`() {
        assertFalse(bigBinaryTree().containsSubTree(smallerBinaryNonSubTree()))
    }

    private fun bigBinaryTree(): Problem10.BinaryTree {
        val binaryTree = Problem10.BinaryTree()
        val root = Problem10.BinaryTreeNode(8, 1)
        binaryTree.root = root

        val left = Problem10.BinaryTreeNode(4, 2)
        val right = Problem10.BinaryTreeNode(12, 2)
        root.leftChild = left
        left.parent = root
        root.rightChild = right
        right.parent = root

        val leftLeft = Problem10.BinaryTreeNode(2, 3)
        val leftRight = Problem10.BinaryTreeNode(6, 3)
        left.leftChild = leftLeft
        leftLeft.parent = left
        left.rightChild = leftRight
        leftRight.parent = left
        val rightLeft = Problem10.BinaryTreeNode(10, 3)
        val rightRight = Problem10.BinaryTreeNode(14, 3)
        right.leftChild = rightLeft
        rightLeft.parent = right
        right.rightChild = rightRight
        rightRight.parent = right

        val leftLeftLeft = Problem10.BinaryTreeNode(1, 4)
        val leftLeftRight = Problem10.BinaryTreeNode(3, 4)
        leftLeft.leftChild = leftLeftLeft
        leftLeftLeft.parent = leftLeft
        leftLeft.rightChild = leftLeftRight
        leftLeftRight.parent = leftLeft
        val leftRightLeft = Problem10.BinaryTreeNode(5, 4)
        val leftRightRight = Problem10.BinaryTreeNode(7, 4)
        leftRight.leftChild = leftRightLeft
        leftRightLeft.parent = leftRight
        leftRight.rightChild = leftRightRight
        leftRightRight.parent = leftRight
        val rightLeftLeft = Problem10.BinaryTreeNode(9, 4)
        val rightLeftRight = Problem10.BinaryTreeNode(11, 4)
        rightLeft.leftChild = rightLeftLeft
        rightLeftLeft.parent = rightLeft
        rightLeft.rightChild = rightLeftRight
        rightLeftRight.parent = rightLeft
        val rightRightLeft = Problem10.BinaryTreeNode(13, 4)
        val rightRightRight = Problem10.BinaryTreeNode(15, 4)
        rightRight.leftChild = rightRightLeft
        rightRightLeft.parent = rightRight
        rightRight.rightChild = rightRightRight
        rightRightRight.parent = rightRight

        //                    8
        //             4               12
        //          2     6        10      14
        //        1  3  5   7    9   11  13   15

        return binaryTree
    }

    private fun smallerBinarySubTree(): Problem10.BinaryTree {
        val binaryTree = Problem10.BinaryTree()
        val root = Problem10.BinaryTreeNode(12, 1)
        binaryTree.root = root

        val left = Problem10.BinaryTreeNode(10, 2)
        val right = Problem10.BinaryTreeNode(14, 2)
        root.leftChild = left
        left.parent = root
        root.rightChild = right
        right.parent = root

        val leftLeft = Problem10.BinaryTreeNode(9, 3)
        val leftRight = Problem10.BinaryTreeNode(11, 3)
        left.leftChild = leftLeft
        leftLeft.parent = left
        left.rightChild = leftRight
        leftRight.parent = left
        val rightLeft = Problem10.BinaryTreeNode(13, 3)
        val rightRight = Problem10.BinaryTreeNode(15, 3)
        right.leftChild = rightLeft
        rightLeft.parent = right
        right.rightChild = rightRight
        rightRight.parent = right

        //          12
        //      10      14
        //    9   11  13   15

        return binaryTree
    }

    private fun smallerBinaryNonSubTree(): Problem10.BinaryTree {
        val binaryTree = Problem10.BinaryTree()
        val root = Problem10.BinaryTreeNode(12, 1)
        binaryTree.root = root

        val left = Problem10.BinaryTreeNode(10, 2)
        val right = Problem10.BinaryTreeNode(14, 2)
        root.leftChild = left
        left.parent = root
        root.rightChild = right
        right.parent = root

        val leftLeft = Problem10.BinaryTreeNode(10, 3)
        val leftRight = Problem10.BinaryTreeNode(11, 3)
        left.leftChild = leftLeft
        leftLeft.parent = left
        left.rightChild = leftRight
        leftRight.parent = left
        val rightLeft = Problem10.BinaryTreeNode(13, 3)
        val rightRight = Problem10.BinaryTreeNode(15, 3)
        right.leftChild = rightLeft
        rightLeft.parent = right
        right.rightChild = rightRight
        rightRight.parent = right

        //          12
        //      10      14
        //    9   11  13   15

        return binaryTree
    }
}