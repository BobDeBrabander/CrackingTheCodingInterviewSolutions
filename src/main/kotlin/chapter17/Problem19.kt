package chapter17

import kotlin.math.sqrt

object Problem19 {

    fun missingOne(list: List<Int>): Int {
        val N = list.size + 1
        val sum1toN = ((1 + N) * N) / 2
        return sum1toN - list.sum()
    }

    fun missingTwo(list: List<Int>): List<Int> {
        val N = list.size + 2
        val sum1ToN = ((1 + N) * N) / 2
        val sumSquared1ToN = sumSquaredToN(N)
        val differenceSum = sum1ToN - list.sum()
        val differenceSquareSum = sumSquared1ToN - list.map { it * it }.sum()

        val missingOne = solveEquation(differenceSum, differenceSquareSum)
        val missingTwo = differenceSum - missingOne
        return listOf(missingOne, missingTwo).sorted()
    }

    private fun sumSquaredToN(N: Int): Int {
        return (1..N).toList().map { it * it }.sum()
    }

    private fun solveEquation(r1: Int, r2: Int): Int {
        //r1 = x + y
        //r2 = x^2 + y^2
        // y = r1 - x
        // x^2 + (r1 - x)^2 = r2
        // x^2 + -2*x*r1 + x^2 + r1^2 = r2
        // 2x^2 - 2*x*r1 + r1^2 - r2 = 0

        // ax^2 + bx + c = 0
        //Trying to solve for (-b += sqrt(b^2 - 4ac)) / 2a
        //So the values of a, b, and c become =>
        val a = 2
        val b = -2 * r1
        val c = r1 * r1 - r2

        return ((-b + sqrt((b * b - 4 * a * c).toDouble())) / (2 * a)).toInt()
    }
}