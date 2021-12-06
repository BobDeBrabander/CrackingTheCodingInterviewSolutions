package chapter8

object Problem12 {

    fun eightQueens() {
        eightQueens(
            0,
            MutableList(8) { MutableList(8) { false } }
        )
    }

    private fun eightQueens(numPlaced: Int, board: MutableList<MutableList<Boolean>>) {
        if (numPlaced == 8) {
            printBoard(board)
            println()
            println("------------------------------")
        }
        val row = numPlaced //every placement on next row
        repeat(8) { col ->
            if (!colHasQueen(board, col) && !diagonalsHaveQueen(board, row, col)){
                board[row][col] = true
                eightQueens(numPlaced+1, board)
                board[row][col] = false
            }
        }
    }

    private fun diagonalsHaveQueen(board: MutableList<MutableList<Boolean>>, row: Int, col: Int): Boolean {
        repeat(7){
            if (checkForQueen(board, row+it, col+it)) return true
            if (checkForQueen(board, row+it, col-it)) return true
            if (checkForQueen(board, row-it, col+it)) return true
            if (checkForQueen(board, row-it, col-it)) return true
        }
        return false
    }

    private fun checkForQueen(board: MutableList<MutableList<Boolean>>, row: Int, col: Int): Boolean{
        if (row < 0 || row >= 8) return false
        if (col < 0 || col >= 8) return false
        return board[row][col]
    }

    private fun colHasQueen(board: List<List<Boolean>>, col: Int): Boolean {
        return board.any { it[col] }
    }

    private fun printBoard(board: List<List<Boolean>>) {
        board.forEach { row ->
            row.forEach { cell ->
                if (cell) print("Q")
                else print("_")
            }
            print("\n")
        }
    }
}