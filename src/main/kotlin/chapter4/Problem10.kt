package chapter4

object Problem10 {

    class BinaryTree {
        var root: BinaryTreeNode? = null

        //Since it is a binary tree and not a binary search tree I can't optimize this treewalk any further
        //Otherwise you could first find the mutual root and then treewalk. Now we have to look at the whole tree.
        fun containsSubTree(other: BinaryTree): Boolean {
            val thisTreeWalk = (this.root?.treeWalk() ?: listOf()).joinToString(",")
            val otherTreeWalk = (other.root?.treeWalk() ?: listOf()).joinToString(",")
            return thisTreeWalk.contains(otherTreeWalk)
        }
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null

        fun treeWalk(): List<Int> {
            val solution = mutableListOf<Int>()
            treeWalk(solution)
            return solution
        }

        private fun treeWalk(inOrderList: MutableList<Int>) {
            leftChild?.treeWalk(inOrderList)
            inOrderList.add(this.data)
            rightChild?.treeWalk(inOrderList)
        }
    }
}