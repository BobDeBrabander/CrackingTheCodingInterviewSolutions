package chapter1

import chapter1.Problem2.permutationOf
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem2Tests {

    @Test
    fun `happy flow test 1`(){
        handleTestCase("aba", "aab", true)
    }

    @Test
    fun `happy flow test 2`(){
        handleTestCase("abb", "bab", true)
    }

    @Test
    fun `unhappy flow test 1`(){
        handleTestCase("aab", "bab", false)
    }

    @Test
    fun `unhappy flow test 2`(){
        handleTestCase("bbb", "bab", false)
    }

    fun handleTestCase(input1: String, input2: String, expectedOutput: Boolean){
        if (expectedOutput) assertTrue(input1.permutationOf(input2))
        else assertFalse (input1.permutationOf(input2))
    }
}