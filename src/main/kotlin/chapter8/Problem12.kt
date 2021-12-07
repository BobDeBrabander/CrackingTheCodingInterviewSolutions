package chapter8

import kotlin.math.abs

object Problem12 {

    private val solutionStrings = mutableSetOf<String>()

    fun eightQueens(): Int {
        eightQueens(
            0,
            MutableList(8) { -1 },
            MutableList(8) { MutableList(8) { false } }
        )
        return solutionStrings.size
    }

    private fun eightQueens(numPlaced: Int, columnsPlaced: MutableList<Int>, board: MutableList<MutableList<Boolean>>) {
        if (numPlaced == 8) {
            printBoard(board)
            println()
            println("------------------------------")
            return
        }
        val row = numPlaced //every placement on next row
        repeat(8) { col ->
            if (isValidPlacement(columnsPlaced, row, col)) {
                columnsPlaced[row] = col
                board[row][col] = true
                eightQueens(numPlaced + 1, columnsPlaced, board)
                board[row][col] = false
            }
        }
    }

    private fun isValidPlacement(columnsPlaced: MutableList<Int>, row: Int, col: Int): Boolean {
        for (i in 0 until row) {
            if (columnsPlaced[i] == col) return false
            val rowDistance = abs(row - i)
            val colDistance = abs(columnsPlaced[i] - col)
            if (rowDistance == colDistance) return false
        }
        return true
    }

    private fun printBoard(board: List<List<Boolean>>) {
        var solutionString = ""
        board.forEach { row ->
            row.forEach { cell ->
                if (cell) {
                    solutionString += "Q"
                    print("Q")
                } else {
                    solutionString += "_"
                    print("_")
                }
            }
            solutionString += "\n"
            print("\n")
        }
        solutionStrings.add(solutionString)
    }
}