package chapter4

import kotlin.math.max
import kotlin.math.min

object Problem5 {

    //Assumption for question: No duplicate values in this tree
    class BinaryTree {
        var root: BinaryTreeNode? = null
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null
    }

    var lastSeenData : Int? = null
    fun BinaryTree.isBST(): Boolean {
        lastSeenData = null
        return root?.isBST() ?: true
    }

    fun BinaryTreeNode.isBST() : Boolean {
        if (this.leftChild != null && !leftChild!!.isBST()) return false
        if (lastSeenData != null && data <= lastSeenData!!) return false
        lastSeenData = data
        if (this.rightChild != null && !rightChild!!.isBST()) return false
        return true
    }
}