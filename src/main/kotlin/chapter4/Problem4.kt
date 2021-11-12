package chapter4

import kotlin.math.abs
import kotlin.math.max

object Problem4 {

    class BinaryTree {
        var root: BinaryTreeNode? = null

        fun isBalanced(): Boolean {
            return root?.isBalancedTreeWalk() ?: true
        }
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null
        // In a normal implementation this wouldn't work because it would have to be reset every time a node is added in it's subtree
        private var maxDepth: Int? = null

        fun isBalancedTreeWalk(): Boolean {
            val rightDepth = rightChild?.maxDepth() ?: depth
            val leftDepth = leftChild?.maxDepth() ?: depth
            if (abs(rightDepth - leftDepth) > 1) return false
            return (leftChild?.isBalancedTreeWalk() ?: true) && (rightChild?.isBalancedTreeWalk() ?: true)
        }

        fun maxDepth(): Int {
            if (maxDepth != null) return maxDepth!!
            if (leftChild == null && rightChild == null) return depth
            if (leftChild == null) return rightChild!!.maxDepth()
            if (rightChild == null) return leftChild!!.maxDepth()
            maxDepth = max(leftChild!!.maxDepth(), rightChild!!.maxDepth())
            return maxDepth!!
        }
    }
}