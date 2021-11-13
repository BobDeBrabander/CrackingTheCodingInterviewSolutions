package chapter4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.test.assertEquals

class Problem9Tests {

    @Test
    fun `Big test generating lot ways`() {
        val binarySearchTree = Problem9.BinarySearchTree()
        val root = Problem9.BinaryTreeNode(8, 1)
        binarySearchTree.root = root

        val left = Problem9.BinaryTreeNode(4, 2)
        val right = Problem9.BinaryTreeNode(12, 2)
        root.leftChild = left
        left.parent = root
        root.rightChild = right
        right.parent = root

        val leftLeft = Problem9.BinaryTreeNode(2, 3)
        val leftRight = Problem9.BinaryTreeNode(6, 3)
        left.leftChild = leftLeft
        leftLeft.parent = left
        left.rightChild = leftRight
        leftRight.parent = left
        val rightLeft = Problem9.BinaryTreeNode(10, 3)
        val rightRight = Problem9.BinaryTreeNode(14, 3)
        right.leftChild = rightLeft
        rightLeft.parent = right
        right.rightChild = rightRight
        rightRight.parent = right

        val leftLeftLeft = Problem9.BinaryTreeNode(1, 4)
        val leftLeftRight = Problem9.BinaryTreeNode(3, 4)
        leftLeft.leftChild = leftLeftLeft
        leftLeftLeft.parent = leftLeft
        leftLeft.rightChild = leftLeftRight
        leftLeftRight.parent = leftLeft
        val leftRightLeft = Problem9.BinaryTreeNode(5, 4)
        val leftRightRight = Problem9.BinaryTreeNode(7, 4)
        leftRight.leftChild = leftRightLeft
        leftRightLeft.parent = leftRight
        leftRight.rightChild = leftRightRight
        leftRightRight.parent = leftRight
        val rightLeftLeft = Problem9.BinaryTreeNode(9, 4)
        val rightLeftRight = Problem9.BinaryTreeNode(11, 4)
        rightLeft.leftChild = rightLeftLeft
        rightLeftLeft.parent = rightLeft
        rightLeft.rightChild = rightLeftRight
        rightLeftRight.parent = rightLeft
        val rightRightLeft = Problem9.BinaryTreeNode(13, 4)
        val rightRightRight = Problem9.BinaryTreeNode(15, 4)
        rightRight.leftChild = rightRightLeft
        rightRightLeft.parent = rightRight
        rightRight.rightChild = rightRightRight
        rightRightRight.parent = rightRight

        //                    8
        //             4               12
        //          2     6        10      14
        //        1  3  5   7    9   11  13   15

        //Amount of different ways = 1! * 2! * 4! * 8! = 1935360 ways

        val waysToInsert = binarySearchTree.returnWaysInserted()
        assertEquals(1935360, waysToInsert.size)
    }

    @Test
    fun `Medium test generating a lot of ways but still checkable`() {
        val binarySearchTree = Problem9.BinarySearchTree()
        val root = Problem9.BinaryTreeNode(8, 1)
        binarySearchTree.root = root

        val left = Problem9.BinaryTreeNode(4, 2)
        val right = Problem9.BinaryTreeNode(12, 2)
        root.leftChild = left
        left.parent = root
        root.rightChild = right
        right.parent = root

        val leftLeft = Problem9.BinaryTreeNode(2, 3)
        val leftRight = Problem9.BinaryTreeNode(6, 3)
        left.leftChild = leftLeft
        leftLeft.parent = left
        left.rightChild = leftRight
        leftRight.parent = left
        val rightLeft = Problem9.BinaryTreeNode(10, 3)
        right.leftChild = rightLeft
        rightLeft.parent = right

        //                    8
        //             4               12
        //          2     6        10

        //Amount of different ways = 1! * 2! * 3! = 12 ways

        val waysToInsert = binarySearchTree.returnWaysInserted()
        assertEquals(12, waysToInsert.size)

        val expectedWays = listOf(
            listOf(8, 4, 12, 2, 6, 10),
            listOf(8, 4, 12, 2, 10, 6),
            listOf(8, 4, 12, 6, 2, 10),
            listOf(8, 4, 12, 6, 10, 2),
            listOf(8, 4, 12, 10, 2, 6),
            listOf(8, 4, 12, 10, 6, 2),
            listOf(8, 12, 4, 2, 6, 10),
            listOf(8, 12, 4, 2, 10, 6),
            listOf(8, 12, 4, 6, 2, 10),
            listOf(8, 12, 4, 6, 10, 2),
            listOf(8, 12, 4, 10, 2, 6),
            listOf(8, 12, 4, 10, 6, 2),
        )

        assertThat(expectedWays).hasSameElementsAs(waysToInsert)
    }

}