package chapter4

object Problem6 {

    //Assumption for question: No duplicate values in this tree
    class BinaryTree {
        var root: BinaryTreeNode? = null
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null

        fun successor(): BinaryTreeNode? {
            if (rightChild != null) {
                var node = rightChild!!
                while (node.leftChild != null) node = node.leftChild!!
                return node
            } else {
                var node = this
                while (node.parent != null && node.parent!!.rightChild == node) node = node.parent!!
                return if (node.parent == null && node.data > data) {
                    //node is root and also the successor
                    node
                } else {
                    //The first parent of which we are the left subtree
                    node.parent
                }
            }
        }
    }
}
