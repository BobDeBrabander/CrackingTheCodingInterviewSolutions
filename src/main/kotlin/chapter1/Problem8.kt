package chapter1

object Problem8 {

    data class Matrix(val rows: MutableList<MutableList<Short>>, val size: Int)

    data class CellIndex(val row: Int, val col: Int)

    fun Matrix.zerofy() {
        val zeroList = mutableListOf<CellIndex>()
        for(i in 0 until rows.size){
            for (j in 0 until rows[i].size){
                if (rows[i][j] == 0.toShort()){
                    zeroList.add(CellIndex(i, j))
                }
            }
        }
        zeroList.forEach {
            this.zerofyColumn(it.col)
            this.zerofyRow(it.row)
        }
    }

    fun Matrix.zerofyRow(row: Int){
        rows[row].indices.forEach {
            rows[row][it] = 0
        }
    }

    fun Matrix.zerofyColumn(col: Int){
        this.rows.forEach{it[col] = 0}
    }
}