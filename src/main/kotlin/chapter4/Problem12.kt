package chapter4

object Problem12 {

    class BinaryTree {
        var root: BinaryTreeNode? = null

        fun numberOfPathsSumTo(sum: Int) = root?.numberOfPathsSumTo(sum, 0, HashMap()) ?: 0
    }

    class BinaryTreeNode(val data: Int, val depth: Int) {
        var parent: BinaryTreeNode? = null
        var leftChild: BinaryTreeNode? = null
        var rightChild: BinaryTreeNode? = null

        fun numberOfPathsSumTo(targetSum: Int, currentSum: Int, pathCount: HashMap<Int, Int>) : Int{
            var newCurrentSum = currentSum + data
            var sum = newCurrentSum - targetSum
            var totalPaths = pathCount.getOrDefault(sum, 0)
            if (newCurrentSum == targetSum) totalPaths++

            pathCount.increment(newCurrentSum, 1)
            totalPaths += leftChild?.numberOfPathsSumTo(targetSum, newCurrentSum, pathCount) ?: 0
            totalPaths += rightChild?.numberOfPathsSumTo(targetSum, newCurrentSum, pathCount) ?: 0
            pathCount.increment(newCurrentSum, -1)

            return totalPaths
        }

        fun HashMap<Int, Int>.increment(key: Int, delta: Int){
            val newCount = this.getOrDefault(key, 0) + delta
            if (newCount == 0){
                this.remove(key)
            } else {
                this[key] = newCount
            }
        }
    }
}