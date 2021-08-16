package chapter1

import chapter1.Problem7.rotateMatrix
import org.junit.Test
import kotlin.test.assertEquals

class Problem7Tests {

    @Test
    fun `simple matrix rotation`(){
        val row1 = mutableListOf<Short>(1, 2, 3)
        val row2 = mutableListOf<Short>(4, 5, 6)
        val row3 = mutableListOf<Short>(7, 8, 9)
        val matrix = Problem7.Matrix(mutableListOf(row1, row2, row3), 3)

        val outRow1 = mutableListOf<Short>(7, 4, 1)
        val outRow2 = mutableListOf<Short>(8, 5, 2)
        val outRow3 = mutableListOf<Short>(9, 6, 3)
        val outMatrix = Problem7.Matrix(mutableListOf(outRow1, outRow2, outRow3), 3)

        handleTestCase(matrix, outMatrix)
    }

    @Test
    fun `simple matrix rotation 2`(){
        val row1 = mutableListOf<Short>(1, 2, 3, 4)
        val row2 = mutableListOf<Short>(5, 6, 7, 8)
        val row3 = mutableListOf<Short>(9, 10, 11, 12)
        val row4 = mutableListOf<Short>(13, 14, 15, 16)
        val matrix = Problem7.Matrix(mutableListOf(row1, row2, row3, row4), 4)

        val outRow1 = mutableListOf<Short>(13, 9, 5, 1)
        val outRow2 = mutableListOf<Short>(14, 10, 6, 2)
        val outRow3 = mutableListOf<Short>(15, 11, 7, 3)
        val outRow4 = mutableListOf<Short>(16, 12, 8, 4)
        val outMatrix = Problem7.Matrix(mutableListOf(outRow1, outRow2, outRow3, outRow4), 4)

        handleTestCase(matrix, outMatrix)
    }


    @Test
    fun `simple matrix rotation 3`(){
        val row1 = mutableListOf<Short>(1, 2, 3, 4, 5)
        val row2 = mutableListOf<Short>(5, 6, 7, 8, 9)
        val row3 = mutableListOf<Short>(9, 10, 11, 12, 13)
        val row4 = mutableListOf<Short>(13, 14, 15, 16, 17)
        val row5 = mutableListOf<Short>(17, 18, 19, 20, 21)
        val matrix = Problem7.Matrix(mutableListOf(row1, row2, row3, row4, row5), 5)

        val outRow1 = mutableListOf<Short>(17, 13, 9, 5, 1)
        val outRow2 = mutableListOf<Short>(18, 14, 10, 6, 2)
        val outRow3 = mutableListOf<Short>(19, 15, 11, 7, 3)
        val outRow4 = mutableListOf<Short>(20, 16, 12, 8, 4)
        val outRow5 = mutableListOf<Short>(21, 17, 13, 9, 5)
        val outMatrix = Problem7.Matrix(mutableListOf(outRow1, outRow2, outRow3, outRow4, outRow5), 5)

        handleTestCase(matrix, outMatrix)
    }

    @Test
    fun `simple matrix rotation 4`(){
        val row1 = mutableListOf<Short>(1, 2, 3, 4, 5, 6, 7, 8)
        val row2 = mutableListOf<Short>(5, 6, 7, 8, 9, 10, 11, 12)
        val row3 = mutableListOf<Short>(9, 10, 11, 12, 13, 14, 15, 16)
        val row4 = mutableListOf<Short>(13, 14, 15, 16, 17, 18, 19, 20)
        val row5 = mutableListOf<Short>(17, 18, 19, 20, 21, 22, 23, 24)
        val row6 = mutableListOf<Short>(21, 22, 23, 24, 25, 26, 27, 28)
        val row7 = mutableListOf<Short>(25, 26, 27, 28, 29, 30, 31, 32)
        val row8 = mutableListOf<Short>(29, 30, 31, 32, 33, 34, 35, 36)
        val matrix = Problem7.Matrix(mutableListOf(row1, row2, row3, row4, row5, row6, row7, row8), 8)

        val outRow1 = mutableListOf<Short>(29, 25, 21, 17, 13, 9, 5, 1)
        val outRow2 = mutableListOf<Short>(30, 26, 22, 18, 14, 10, 6, 2)
        val outRow3 = mutableListOf<Short>(31, 27, 23, 19, 15, 11, 7, 3)
        val outRow4 = mutableListOf<Short>(32, 28, 24, 20, 16, 12, 8, 4)
        val outRow5 = mutableListOf<Short>(33, 29, 25, 21, 17, 13, 9, 5)
        val outRow6 = mutableListOf<Short>(34, 30, 26, 22, 18, 14, 10, 6)
        val outRow7 = mutableListOf<Short>(35, 31, 27, 23, 19, 15, 11, 7)
        val outRow8 = mutableListOf<Short>(36, 32, 28, 24, 20, 16, 12, 8)
        val outMatrix = Problem7.Matrix(mutableListOf(outRow1, outRow2, outRow3, outRow4, outRow5, outRow6, outRow7, outRow8), 8)

        handleTestCase(matrix, outMatrix)
    }


    fun handleTestCase(inputMatrix: Problem7.Matrix, expectedOutput: Problem7.Matrix){
        var outMatrix = inputMatrix.apply{this.rotateMatrix()}
        assertEquals(expectedOutput, outMatrix)
    }
}