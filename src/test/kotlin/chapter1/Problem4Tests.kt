package chapter1

import chapter1.Problem4.isPermutationOfPalindrome
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem4Tests {

    @Test
    fun `A string that is a palindrome permutation 1`(){
        handleTestCase("Tact Coa", true)
    }

    @Test
    fun `A string that is a palindrome permutation 2`(){
        handleTestCase("abcbadd", true)
    }

    @Test
    fun `A string that is a palindrome permutation edge case`(){
        handleTestCase("  ", true)
    }

    @Test
    fun `A string that is not a palindrome permutation 1`(){
        handleTestCase("Tactbd Coa", false)
    }

    @Test
    fun `A string that is not a palindrome permutation 2`(){
        handleTestCase("abcd", false)
    }

    fun handleTestCase(inputString: String, expectedOutput: Boolean) {
        if (expectedOutput) assertTrue(inputString.isPermutationOfPalindrome())
        else assertFalse (inputString.isPermutationOfPalindrome())
    }

}