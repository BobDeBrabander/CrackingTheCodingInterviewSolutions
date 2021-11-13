package chapter4

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class Problem8Tests {

    @Test
    fun `Big test going over multiple cases`() {
        val binaryTree = Problem8.BinaryTree()
        val root = Problem8.BinaryTreeNode(1, 1)
        binaryTree.root = root

        val left = Problem8.BinaryTreeNode(2, 2)
        val right = Problem8.BinaryTreeNode(3, 2)
        root.leftChild = left
        left.parent = root
        root.rightChild = right
        right.parent = root

        val leftLeft = Problem8.BinaryTreeNode(4, 3)
        val leftRight = Problem8.BinaryTreeNode(5, 3)
        left.leftChild = leftLeft
        leftLeft.parent = left
        left.rightChild = leftRight
        leftRight.parent = left
        val rightLeft = Problem8.BinaryTreeNode(6, 3)
        val rightRight = Problem8.BinaryTreeNode(7, 3)
        right.leftChild = rightLeft
        rightLeft.parent = right
        right.rightChild = rightRight
        rightRight.parent = right

        val leftLeftLeft = Problem8.BinaryTreeNode(8, 4)
        val leftLeftRight = Problem8.BinaryTreeNode(9, 4)
        leftLeft.leftChild = leftLeftLeft
        leftLeftLeft.parent = leftLeft
        leftLeft.rightChild = leftLeftRight
        leftLeftRight.parent = leftLeft
        val leftRightLeft = Problem8.BinaryTreeNode(10, 4)
        val leftRightRight = Problem8.BinaryTreeNode(11, 4)
        leftRight.leftChild = leftRightLeft
        leftRightLeft.parent = leftRight
        leftRight.rightChild = leftRightRight
        leftRightRight.parent = leftRight
        val rightLeftLeft = Problem8.BinaryTreeNode(12, 4)
        val rightLeftRight = Problem8.BinaryTreeNode(13, 4)
        rightLeft.leftChild = rightLeftLeft
        rightLeftLeft.parent = rightLeft
        rightLeft.rightChild = rightLeftRight
        rightLeftRight.parent = rightLeft
        val rightRightLeft = Problem8.BinaryTreeNode(14, 4)
        val rightRightRight = Problem8.BinaryTreeNode(15, 4)
        rightRight.leftChild = rightRightLeft
        rightRightLeft.parent = rightRight
        rightRight.rightChild = rightRightRight
        rightRightRight.parent = rightRight

        //                    1
        //             2               3
        //          4     5         6      7
        //        8  9  10  11   12  13  14  15

        // common ancestor of 8 and 9 should be 4
        assertEquals(leftLeft, leftLeftLeft.commonAncestor(leftLeftRight))

        //common ancestor of 8 and 4 should be 2
        assertEquals(left, leftLeft.commonAncestor(leftLeftLeft))

        //common ancestor of 10 and 1 should be null as 1 has no ancestor
        assertNull(leftRightLeft.commonAncestor(root))

        //common ancestor of 11 and 12 should be the root
        assertEquals(root, leftRightRight.commonAncestor(rightLeftLeft))

        //common ancestor of 12 and 15 should be 3
        assertEquals(right, rightLeftLeft.commonAncestor(rightRightRight))
    }

}