package chapter17

object Problem24 {

    data class Cell(val row: Int, val col: Int)
    data class SubMatrix(val startCell: Cell, val endCell: Cell)

    //Assumption: At least 1 cell in the matrix
    fun maxSubMatrix(matrix: List<List<Int>>): SubMatrix {
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
        var bestSum = matrix[0][0]
        var best = SubMatrix(Cell(0, 0), Cell(0, 0))
        for (rowStart in matrix.indices) {
            for (colStart in matrix.indices) {
                for (rowEnd in rowStart until matrix.size) {
                    for (colEnd in colStart until matrix.size) {
                        val sum = sumUnder[rowStart][colStart] -
                                sumUnder[rowStart].getOrElse(colEnd + 1) { 0 } -
                                sumUnder.getOrElse(rowEnd + 1) { mutableListOf() }.getOrElse(colStart) { 0 } +
                                sumUnder.getOrElse(rowEnd + 1) { mutableListOf() }.getOrElse(colEnd + 1) { 0 }

                        if (sum > bestSum) {
                            best = SubMatrix(Cell(rowStart, colStart), Cell(rowEnd, colEnd))
                            bestSum = sum
                        }
                    }
                }
            }
        }
        return best

        //Faster solution exists taking it from N^4 to N^3 using the maxSubArray problem
    }
}