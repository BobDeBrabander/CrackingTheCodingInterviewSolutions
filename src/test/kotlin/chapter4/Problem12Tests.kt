package chapter4

import org.junit.Test
import kotlin.test.assertEquals

class Problem12Tests {

    @Test
    fun `Test on big binary tree`() {
        val binaryTree = bigBinaryTree()

        assertEquals(4, binaryTree.numberOfPathsSumTo(15))
        //8 + 4 + 2 + 1
        //9 + 4 + 2
        //10 + 5
        //15

        assertEquals(3, binaryTree.numberOfPathsSumTo(18))
        //10 + 5 + 2 + 1
        //11 + 5 + 2
        //12 + 6

        assertEquals(3, binaryTree.numberOfPathsSumTo(7))
        //5 + 2
        //4 + 2 + 1
        //7

        assertEquals(1, binaryTree.numberOfPathsSumTo(26))
        //15 + 7 + 3 + 1
    }


    //                    1
    //             2               3
    //          4     5         6      7
    //        8  9  10  11   12  13  14  15
    private fun bigBinaryTree(): Problem12.BinaryTree {
        val binaryTree = Problem12.BinaryTree()
        val root = Problem12.BinaryTreeNode(1, 1)
        binaryTree.root = root

        val left = Problem12.BinaryTreeNode(2, 2)
        val right = Problem12.BinaryTreeNode(3, 2)
        root.leftChild = left
        left.parent = root
        root.rightChild = right
        right.parent = root

        val leftLeft = Problem12.BinaryTreeNode(4, 3)
        val leftRight = Problem12.BinaryTreeNode(5, 3)
        left.leftChild = leftLeft
        leftLeft.parent = left
        left.rightChild = leftRight
        leftRight.parent = left
        val rightLeft = Problem12.BinaryTreeNode(6, 3)
        val rightRight = Problem12.BinaryTreeNode(7, 3)
        right.leftChild = rightLeft
        rightLeft.parent = right
        right.rightChild = rightRight
        rightRight.parent = right

        val leftLeftLeft = Problem12.BinaryTreeNode(8, 4)
        val leftLeftRight = Problem12.BinaryTreeNode(9, 4)
        leftLeft.leftChild = leftLeftLeft
        leftLeftLeft.parent = leftLeft
        leftLeft.rightChild = leftLeftRight
        leftLeftRight.parent = leftLeft
        val leftRightLeft = Problem12.BinaryTreeNode(10, 4)
        val leftRightRight = Problem12.BinaryTreeNode(11, 4)
        leftRight.leftChild = leftRightLeft
        leftRightLeft.parent = leftRight
        leftRight.rightChild = leftRightRight
        leftRightRight.parent = leftRight
        val rightLeftLeft = Problem12.BinaryTreeNode(12, 4)
        val rightLeftRight = Problem12.BinaryTreeNode(13, 4)
        rightLeft.leftChild = rightLeftLeft
        rightLeftLeft.parent = rightLeft
        rightLeft.rightChild = rightLeftRight
        rightLeftRight.parent = rightLeft
        val rightRightLeft = Problem12.BinaryTreeNode(14, 4)
        val rightRightRight = Problem12.BinaryTreeNode(15, 4)
        rightRight.leftChild = rightRightLeft
        rightRightLeft.parent = rightRight
        rightRight.rightChild = rightRightRight
        rightRightRight.parent = rightRight

        return binaryTree
    }
}