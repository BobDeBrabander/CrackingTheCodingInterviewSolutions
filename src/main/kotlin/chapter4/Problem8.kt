package chapter4

object Problem8 {

    class BinaryTree {
        var root: BinaryTreeNode? = null
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null

        fun commonAncestor(other: BinaryTreeNode): BinaryTreeNode? {
            var node1 = this
            var node2 = other
            while (node1.depth > node2.depth) node1 = node1.parent!!
            while (node2.depth > node1.depth) node2 = node2.parent!!
            //Now we should have 2 nodes that are at the same depth (or the same node)
            //If it is the same node I assume it should be the parent of this node otherwise it wouldn't be the
            //Ancestor for one of the nodes.
            //If both nodes are the root then one of the nodes was the root to start with and they have no common ancestor

            //Make sure we always will take the ancestor and not one of the input nodes
            if (node1.parent == null) return null
            else {
                node1 = node1.parent!!
                node2 = node2.parent!!
            }

            //find the first common ancestor
            while (node1 != node2 && node1.parent != null){
                node1 = node1.parent!!
                node2 = node2.parent!!
            }
            return if (node1 == node2) node1
            else null
        }
    }
}
