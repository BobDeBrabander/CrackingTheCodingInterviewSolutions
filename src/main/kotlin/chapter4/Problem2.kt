package chapter4

import kotlin.math.max

object Problem2 {

    class BinarySearchTree {
        var root: BinarySearchNode? = null

        fun height() = root?.maxDepth() ?: 0
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
    }

    //Sorted list into binary search tree
    fun List<Int>.toBinarySearchTree(): BinarySearchTree {
        return this.toBinarySearchTree(1, 0, this.size-1)
    }

    private fun List<Int>.toBinarySearchTree(depth: Int, start: Int, endIncl: Int): BinarySearchTree {
        val numNodes = endIncl - start + 1
        val depthTree = kotlin.math.ceil(kotlin.math.log2((numNodes+1).toDouble())).toInt()
        val fullTree =  (1 shl depthTree) - 1
        val fullSubtreeSize = (fullTree - 1) / 2

        val mid = if (fullSubtreeSize == 0) start else start + fullSubtreeSize
        val beforeMid = mid - 1
        val afterMid = mid + 1

        var thisNode = BinarySearchNode(this[mid], depth)
        if (beforeMid >= start){
            var leftTree = this.toBinarySearchTree(depth + 1, start, beforeMid)
            thisNode.leftChild = leftTree.root
            leftTree.root?.parent = thisNode

        }
        if (afterMid <= endIncl){
            var rightTree = this.toBinarySearchTree(depth + 1, afterMid, endIncl)
            thisNode.rightChild = rightTree.root
            rightTree.root?.parent = thisNode
        }
        return BinarySearchTree().apply { this.root = thisNode }
    }
}