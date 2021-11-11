package chapter4

import java.util.LinkedList
import kotlin.math.max

object Problem3 {

    class BinarySearchTree {
        var root: BinarySearchNode? = null

        fun height() = root?.maxDepth() ?: 0

        fun toLinkedLists() : MutableList<LinkedList<Int>> {
            val linkedLists = MutableList(height()){ LinkedList<Int>() }
            root?.treeWalk(linkedLists)
            return linkedLists
        }
    }

    class BinarySearchNode(val data: Int, val depth: Int) {
        var parent: BinarySearchNode? = null
        var leftChild: BinarySearchNode? = null
        var rightChild: BinarySearchNode? = null

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