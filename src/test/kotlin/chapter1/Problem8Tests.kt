package chapter1

import chapter1.Problem8.zerofy
import org.junit.Test
import kotlin.test.assertEquals

class Problem8Tests {

    @Test
    fun `simple matrix zerofy`(){
        val row1 = mutableListOf<Short>(1, 0, 3)
        val row2 = mutableListOf<Short>(4, 5, 6)
        val row3 = mutableListOf<Short>(7, 8, 9)
        val matrix = Problem8.Matrix(mutableListOf(row1, row2, row3), 3)

        val outRow1 = mutableListOf<Short>(0, 0 , 0)
        val outRow2 = mutableListOf<Short>(4, 0, 6)
        val outRow3 = mutableListOf<Short>(7, 0, 9)
        val outMatrix = Problem8.Matrix(mutableListOf(outRow1, outRow2, outRow3), 3)

        handleTestCase(matrix, outMatrix)
    }

    @Test
    fun `simple matrix zerofy 2`(){
        val row1 = mutableListOf<Short>(1, 2, 3, 4)
        val row2 = mutableListOf<Short>(5, 6, 0, 8)
        val row3 = mutableListOf<Short>(9, 10, 11, 12)
        val row4 = mutableListOf<Short>(13, 14, 15, 16)
        val matrix = Problem8.Matrix(mutableListOf(row1, row2, row3, row4), 4)

        val outRow1 = mutableListOf<Short>(1, 2, 0, 4)
        val outRow2 = mutableListOf<Short>(0, 0, 0, 0)
        val outRow3 = mutableListOf<Short>(9, 10, 0, 12)
        val outRow4 = mutableListOf<Short>(13, 14, 0, 16)
        val outMatrix = Problem8.Matrix(mutableListOf(outRow1, outRow2, outRow3, outRow4), 4)

        handleTestCase(matrix, outMatrix)
    }


    @Test
    fun `complex matrix zerofy`(){
        val row1 = mutableListOf<Short>(1, 2, 3, 4, 5)
        val row2 = mutableListOf<Short>(5, 0, 7, 8, 9)
        val row3 = mutableListOf<Short>(9, 10, 11, 12, 13)
        val row4 = mutableListOf<Short>(13, 14, 15, 0, 17)
        val row5 = mutableListOf<Short>(17, 18, 19, 20, 21)
        val matrix = Problem8.Matrix(mutableListOf(row1, row2, row3, row4, row5), 5)

        val outRow1 = mutableListOf<Short>(1, 0, 3, 0, 5)
        val outRow2 = mutableListOf<Short>(0, 0, 0, 0, 0)
        val outRow3 = mutableListOf<Short>(9, 0, 11, 0, 13)
        val outRow4 = mutableListOf<Short>(0, 0, 0, 0, 0)
        val outRow5 = mutableListOf<Short>(17, 0, 19, 0, 21)
        val outMatrix = Problem8.Matrix(mutableListOf(outRow1, outRow2, outRow3, outRow4, outRow5), 5)

        handleTestCase(matrix, outMatrix)
    }


    fun handleTestCase(inputMatrix: Problem8.Matrix, expectedOutput: Problem8.Matrix){
        var outMatrix = inputMatrix.apply{this.zerofy()}
        assertEquals(expectedOutput, outMatrix)
    }
}