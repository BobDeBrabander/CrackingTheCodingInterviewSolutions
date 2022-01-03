package chapter17

object Problem24Attempt2 {

    data class Cell(val row: Int, val col: Int)
    data class ColRange(val c1: Int, val c2: Int)
    data class MaxSubArray(val sum: Int, val colRange: ColRange)
    data class SubMatrix(val startCell: Cell, val endCell: Cell)

    //Assumption: at least one cell
    fun maxSubMatrix(matrix: List<List<Int>>): SubMatrix {
        if (matrix.isEmpty()) throw IllegalArgumentException()
        val R = matrix.size
        val C = matrix[0].size

        var maxSum = matrix[0][0]
        var bestSubMatrix = SubMatrix(Cell(0, 0), Cell(0, 0))
        var rowsSummed : MutableList<Int>

        for(rStart in 0 until R){
            rowsSummed = MutableList(C) {0}
            for (rEnd in rStart until R) {
                for (col in 0 until C) {
                    rowsSummed[col] += matrix[rEnd][col]
                    val bestSubArray = maxSubArray(rowsSummed)
                    if (bestSubArray.sum > maxSum) {
                        maxSum = bestSubArray.sum
                        bestSubMatrix = SubMatrix(
                            Cell(rStart, bestSubArray.colRange.c1),
                            Cell(rEnd, bestSubArray.colRange.c2)
                        )
                    }
                }
            }
        }
        return bestSubMatrix
    }

    private fun maxSubArray(list: List<Int>) : MaxSubArray {
        var maxSum = list[0]
        var bestRange = ColRange(0, 0)
        var curStart = 0
        var curSum = 0
        for (i in list.indices) {
            curSum += list[i]
            if (curSum > maxSum) {
                maxSum = curSum
                bestRange = ColRange(curStart, i)
            }
            if (curSum < 0) {
                curStart = i+1
                curSum = 0
            }
        }
        return MaxSubArray(maxSum, bestRange)
    }
}