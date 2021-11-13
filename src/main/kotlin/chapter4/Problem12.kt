package chapter4

object Problem12 {

    class BinaryTree {
        var root: BinaryTreeNode? = null

        fun numberOfPathsSumTo(sum: Int) = root?.numberOfPathsSumTo(sum) ?: 0
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null

        fun numberOfPathsSumTo(sum: Int) = numberOfPathsSumTo(mutableListOf(), sum)

        private fun numberOfPathsSumTo(possibleSumsTillNow: MutableList<Int>, sum: Int): Int {
            var possibleSumsTillNowCopy = possibleSumsTillNow.map { it + data }.toMutableList()
            possibleSumsTillNowCopy.add(data)
            val sumsToSumHere = possibleSumsTillNowCopy.count { it == sum }
            val sumsLeft = if (leftChild != null) leftChild!!.numberOfPathsSumTo(possibleSumsTillNowCopy, sum) else 0
            val sumsRight = if (rightChild != null) rightChild!!.numberOfPathsSumTo(possibleSumsTillNowCopy, sum) else 0
            return sumsToSumHere + sumsLeft + sumsRight
        }
    }
}