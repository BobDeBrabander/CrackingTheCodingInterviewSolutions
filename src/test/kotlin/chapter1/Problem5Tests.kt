package chapter1

import chapter1.Problem5.oneEditAway
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem5Tests {

    @Test
    fun `one edit away test 1`(){
        handleTest("pale", "ple", true)
    }

    @Test
    fun `one edit away test 2`(){
        handleTest("pales", "pale", true)
    }

    @Test
    fun `one edit away test 3`(){
        handleTest("pale", "bale", true)
    }

    @Test
    fun `one edit away test 4`(){
        handleTest("", "b", true)
    }

    @Test
    fun `zero edit away test 1`(){
        handleTest("pale", "pale", true)
    }

    @Test
    fun `zero edit away test 2`(){
        handleTest("", "", true)
    }

    @Test
    fun `more than 1 edit away test 1`(){
        handleTest("pale", "le", false)
    }

    @Test
    fun `more than 1 edit away test 2`(){
        handleTest("pale", "leap", false)
    }

    @Test
    fun `more than 1 edit away test 3`(){
        handleTest("pale", "pael", false)
    }

    private fun handleTest(inputString1: String, inputString2: String, expectedOutput: Boolean){
        if (expectedOutput) assertTrue(oneEditAway(inputString1, inputString2))
        else assertFalse(oneEditAway(inputString1, inputString2))
    }
}