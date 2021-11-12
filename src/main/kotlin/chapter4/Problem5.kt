package chapter4

import kotlin.math.max
import kotlin.math.min

object Problem5 {

    //Assumption for question: No duplicate values in this tree
    class BinaryTree {
        var root: BinaryTreeNode? = null

        fun isBST(): Boolean {
            return root?.isBST() ?: true
        }
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null

        // In a normal implementation this wouldn't work because it would have to be reset every time a node is added in it's subtree
        private var min: Int? = null
        private var max: Int? = null

        fun isBST(): Boolean {
            if (leftChild != null) {
                if (leftChild!!.maxValueInTree() > data) return false
            }
            if (rightChild != null) {
                if (rightChild!!.minValueInTree() < data) return false
            }
            return leftChild?.isBST() ?: true && rightChild?.isBST() ?: true
        }

        fun minValueInTree(): Int {
            if (min != null) return min!!
            val leftValue = leftChild?.minValueInTree() ?: data
            val rightValue = rightChild?.minValueInTree() ?: data
            min = min(data, min(leftValue,rightValue))
            return min!!
        }

        fun maxValueInTree(): Int {
            if (max != null) return max!!
            val leftValue = leftChild?.minValueInTree() ?: data
            val rightValue = rightChild?.minValueInTree() ?: data
            max = max(data, max(leftValue,rightValue))
            return max!!
        }
    }
}