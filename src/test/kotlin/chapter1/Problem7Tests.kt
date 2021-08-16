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

    fun handleTestCase(inputMatrix: Problem7.Matrix, expectedOutput: Problem7.Matrix){
        var outMatrix = inputMatrix.apply{this.rotateMatrix()}
        assertEquals(expectedOutput, outMatrix)
    }
}