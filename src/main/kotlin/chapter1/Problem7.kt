package chapter1

object Problem7 {

    data class Matrix(val rows: MutableList<MutableList<Short>>, val size: Int)

    fun Matrix.rotateMatrix() {
        for (i in 0..((size - 1) / 2)) {
            for (j in i..(size - 2 - i)) {
                val cell1 = CellIndex(i, j)
                val cell2 = cell1.get90Cell(size)
                val cell3 = cell2.get90Cell(size)
                val cell4 = cell3.get90Cell(size)
                this.swap(cell1, cell2)
                this.swap(cell2, cell3)
                this.swap(cell3, cell4)
                // cell1 -> cell 4
                //  ^          |
                //  |          v
                // cell 2 <- cell 3
            }
        }
    }

    data class CellIndex(val row: Int, val col: Int){
        //row,col => -col, row
        fun get90Cell(size: Int): CellIndex{
            val newRow = size - 1 - col
            val newCol = row
            return CellIndex(newRow, newCol)
        }
    }

    fun Matrix.swap(i1: CellIndex, i2: CellIndex) {
        val cell2 = this.rows[i2.row][i2.col]
        this.rows[i2.row][i2.col] = this.rows[i1.row][i1.col]
        this.rows[i1.row][i1.col] = cell2
    }
}