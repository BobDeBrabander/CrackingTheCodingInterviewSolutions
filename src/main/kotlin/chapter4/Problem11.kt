package chapter4

import kotlin.random.Random

object Problem11 {

    //This tree could be futher improved by keeping it balanced like a BST
    class BinaryTreeNode(data: Int, val depth: Int) {
        var data : Int? = null
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null
        var nodeNum: Int = 1

        init {
            this.data = data
        }

        fun increaseNodeNum(){
            nodeNum++
            if (parent != null) parent!!.increaseNodeNum()
        }

        fun decreaseNodeNum(){
            nodeNum--
            if (parent != null) parent!!.decreaseNodeNum()
        }

        fun insert(data: Int) {
            if (this.data == null) {
                this.data = data
                increaseNodeNum()
            } else if (data == this.data!!) throw IllegalArgumentException("Duplicate key not allowed")
            else if (data < this.data!!) {
                if (this.leftChild != null) leftChild!!.insert(data)
                else {
                    this.leftChild = BinaryTreeNode(data, depth + 1)
                    increaseNodeNum()
                }
            } else {
                //data > this.data
                if (this.rightChild != null) rightChild!!.insert(data)
                else {
                    this.rightChild = BinaryTreeNode(data, depth + 1)
                    increaseNodeNum()
                }
            }
        }

        fun find(data: Int): BinaryTreeNode? {
            return if (this.data == null) null
            else if (this.data == data) this
            else if (data < this.data!! && leftChild != null) leftChild!!.find(data)
            else if (data > this.data!! && rightChild != null) rightChild!!.find(data)
            else null
        }

        fun delete(data: Int) {
            val node = find(data) ?: return //Nothing to delete
            node.delete()
        }

        fun delete(){
            val parent = parent
            val nodeIsRoot = parent == null
            val nodeIsLeftChild = parent != null && parent.leftChild == this
            val nodeIsRightChild = parent != null && parent.rightChild == this

            if (leftChild == null && rightChild == null) {
                //Node is a leaf
                data = null
                decreaseNodeNum()
                when {
                    nodeIsLeftChild -> parent!!.leftChild = null
                    nodeIsRightChild -> parent!!.rightChild = null
                }
                this.parent = null
            } else if (leftChild == null && rightChild != null){
                data = rightChild!!.data
                rightChild!!.data = null
                nodeNum = rightChild!!.nodeNum
                leftChild = rightChild!!.leftChild
                rightChild = rightChild!!.rightChild
                decreaseNodeNum()
                //copy over state of right child and copy its children
            } else if (rightChild == null && leftChild != null){
                data = leftChild!!.data
                nodeNum = leftChild!!.nodeNum
                leftChild = leftChild!!.leftChild
                rightChild = leftChild!!.rightChild
                decreaseNodeNum()
                //copy over state of left child and copy its children
            } else {
                //Copy over the right child's data and then delete the right child to fix the subtree
                data = rightChild!!.data
                rightChild!!.delete()
            }
        }

        fun getRandomNode() : BinaryTreeNode{
            val randomNodeNum = Random.nextInt(nodeNum)
            val leftNodeNum = leftChild?.nodeNum ?: 0

            return if (randomNodeNum == 0) this
            else if (leftNodeNum != 0 && randomNodeNum in 1..leftNodeNum) leftChild!!.getRandomNode()
            else rightChild!!.getRandomNode()
        }
    }
}