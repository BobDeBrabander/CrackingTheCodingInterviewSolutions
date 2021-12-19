package chapter17

import kotlin.math.min

object Problem23 {

    data class Cell(val row: Int, val col: Int)
    data class SubSquareMatrix(val startCell: Cell, val size: Int)

    //passed is an NxN matrix
    //find a submatrix MxM with M<= N such that all values in that matrix are 1
    fun maxSubSquare(matrix: List<List<Int>>): SubSquareMatrix? {
        val sumUnder = MutableList(matrix.size) { MutableList(matrix.size) { 0 } }
        for (row in matrix.lastIndex downTo 0) {
            for (col in matrix.lastIndex downTo 0) {
                sumUnder[row][col] =
                    matrix[row][col] +
                            sumUnder.getOrElse(row + 1) { mutableListOf() }.getOrElse(col) { 0 } +
                            sumUnder[row].getOrElse(col + 1) { 0 } -
                            sumUnder.getOrElse(row + 1) { mutableListOf() }.getOrElse(col + 1) { 0 }

            }
        }
        var bestFound: SubSquareMatrix? = null
        for (row in matrix.lastIndex downTo 0) {
            for (col in matrix.lastIndex downTo 0) {
                val maxSize = min(matrix.lastIndex - col + 1, matrix.lastIndex - row + 1)
                if (maxSize == 0 || (bestFound != null && bestFound.size > maxSize)) continue
                val startStep = bestFound?.size ?: 0 //If we have a bestFound we only try sizes which would improve our bestFound
                for (step in startStep until maxSize) {
                    val squareSum = sumUnder[row][col] -
                            sumUnder.getOrElse(row + step + 1) { mutableListOf() }.getOrElse(col) { 0 } -
                            sumUnder[row].getOrElse(col + step + 1) { 0 } +
                            sumUnder.getOrElse(row + step + 1) { mutableListOf() }.getOrElse(col + step + 1) { 0 }
                    if (squareSum == (step + 1) * (step + 1) && (bestFound == null || squareSum >= bestFound.size)) {
                        bestFound = SubSquareMatrix(Cell(row, col), step + 1)
                    }
                }

            }
        }
        return bestFound
    }
}