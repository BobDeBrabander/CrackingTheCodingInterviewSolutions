package chapter4

import java.util.LinkedList
import kotlin.math.max

object Problem9 {

    //This is not actually a BST but for this question all tests will have that be the case
    //Assumption: no duplicate values in the tree
    class BinarySearchTree {
        var root: BinaryTreeNode? = null

        fun returnWaysInserted(): MutableList<MutableList<Int>> {
            val levels = toLinkedLists()
            var solutions = MutableList<MutableList<Int>>(1) { mutableListOf() }

            fun makeSolutions(curDepth: Int) {
                var levelPermutations = levels[curDepth].toMutableList().permutations()
                var newSolutions = mutableListOf<MutableList<Int>>()
                solutions.forEach { prevSolution ->
                    val prevSolutionCopy = prevSolution.toMutableList()
                    levelPermutations.forEach { element ->
                        val newSolution = prevSolutionCopy.toMutableList().apply { this.addAll(element) }
                        newSolutions.add(newSolution)
                    }
                }
                solutions = newSolutions
                if (curDepth < levels.size - 1) makeSolutions(curDepth + 1)
            }
            makeSolutions(0)
            return solutions
        }

        private fun MutableList<Int>.permutations(): List<List<Int>> {
            val solutions = mutableListOf<MutableList<Int>>()
            permutations(this.toMutableList(), mutableListOf(), solutions)
            return solutions
        }

        private fun permutations(
            elementsLeft: MutableList<Int>,
            currentSequence: MutableList<Int>,
            solutions: MutableList<MutableList<Int>>
        ) {
            val currentSequenceCopy = currentSequence.toMutableList()
            val elementsLeftCopy = elementsLeft.toMutableList()

            if (elementsLeftCopy.isEmpty()) {
                solutions.add(currentSequenceCopy.toMutableList())
            } else {
                elementsLeft.forEach {
                    currentSequenceCopy.add(it)
                    elementsLeftCopy.remove(it)
                    permutations(elementsLeftCopy, currentSequenceCopy, solutions)
                    currentSequenceCopy.removeLast()
                    elementsLeftCopy.add(it)
                }
            }
        }

        //Reused this code from problem 4
        fun height() = root?.maxDepth() ?: 0
        fun toLinkedLists(): MutableList<LinkedList<Int>> {
            val linkedLists = MutableList(height()) { LinkedList<Int>() }
            root?.treeWalk(linkedLists)
            return linkedLists
        }
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null


        //Reused this code from problem 4
        fun maxDepth(): Int {
            if (leftChild == null && rightChild == null) return depth
            if (leftChild == null) return rightChild!!.maxDepth()
            if (rightChild == null) return leftChild!!.maxDepth()
            return max(leftChild!!.maxDepth(), rightChild!!.maxDepth())
        }

        //Reused this code from problem 4
        fun treeWalk(list: MutableList<LinkedList<Int>>) {
            leftChild?.treeWalk(list)
            list[depth - 1].addLast(this.data)
            rightChild?.treeWalk(list)
        }
    }
}
