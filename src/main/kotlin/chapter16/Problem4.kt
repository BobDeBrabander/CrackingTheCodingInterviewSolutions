package chapter16

object Problem4 {

    //This code could be made more generic with a generic check function that has:
    //  a starting position and an rowIncrement, columnIncrement for which cell to check next
    //  if all the checked cells are the same as the first, and the first not being _, then we have a winner

    //Assuming this is a board of 3x3 with all characters either being X, O, or _
    fun someoneHasWon(ticTacToeBoard: List<List<Char>>) : Boolean {
        for (row in 0..2) {
            if (ticTacToeBoard[row].all { it =='X'} || ticTacToeBoard[row].all {it == 'O'}) return true
        }
        for (col in 0..2) {
            val column = listOf(ticTacToeBoard[0][col], ticTacToeBoard[1][col], ticTacToeBoard[2][col])
            if (column.all { it =='X'} || column.all {it == 'O'}) return true
        }
        val diagonal1 = listOf(ticTacToeBoard[0][0], ticTacToeBoard[1][1], ticTacToeBoard[2][2])
        if (diagonal1.all { it =='X'} || diagonal1.all {it == 'O'}) return true

        val diagonal2 = listOf(ticTacToeBoard[2][0], ticTacToeBoard[1][1], ticTacToeBoard[0][2])
        if (diagonal2.all { it =='X'} || diagonal1.all {it == 'O'}) return true

        return false
    }
}