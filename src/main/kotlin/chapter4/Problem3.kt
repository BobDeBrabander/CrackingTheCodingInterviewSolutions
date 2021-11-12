package chapter4

import java.util.LinkedList
import kotlin.math.max

object Problem3 {

    class BinaryTree {
        var root: BinaryTreeNode? = null

        fun height() = root?.maxDepth() ?: 0

        fun toLinkedLists() : MutableList<LinkedList<Int>> {
            val linkedLists = MutableList(height()){ LinkedList<Int>() }
            root?.treeWalk(linkedLists)
            return linkedLists
        }
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null

        fun maxDepth(): Int {
            if (leftChild == null && rightChild == null) return depth
            if (leftChild == null) return rightChild!!.maxDepth()
            if (rightChild == null) return leftChild!!.maxDepth()
            return max(leftChild!!.maxDepth(), rightChild!!.maxDepth())
        }

        fun treeWalk(list: MutableList<LinkedList<Int>>){
            leftChild?.treeWalk(list)
            list[depth-1].addLast(this.data)
            rightChild?.treeWalk(list)
        }
    }
}