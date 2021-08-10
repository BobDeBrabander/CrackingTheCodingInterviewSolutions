package chapter1

import chapter1.Problem2.permutationOf
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem2Tests {

    @Test
    fun `Strings that are permutations of each other test 1`(){
        handleTestCase("aba", "aab", true)
    }

    @Test
    fun `Strings that are permutations of each other test 2`(){
        handleTestCase("abb", "bab", true)
    }

    @Test
    fun `Strings that are not permutations of each other test 1`(){
        handleTestCase("aab", "bab", false)
    }

    @Test
    fun `Strings that are not permutations of each other test 2`(){
        handleTestCase("bbb", "bab", false)
    }

    fun handleTestCase(input1: String, input2: String, expectedOutput: Boolean){
        if (expectedOutput) assertTrue(input1.permutationOf(input2))
        else assertFalse (input1.permutationOf(input2))
    }
}