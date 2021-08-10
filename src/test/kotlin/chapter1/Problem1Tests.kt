package chapter1

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem1Tests {

    @Test
    fun `happy flow test 1`() {
        handleTestCase("abcdefg", true)
    }

    @Test
    fun `happy flow test 2`() {
        handleTestCase("abcdefg@#$%.!", true)
    }

    @Test
    fun `happy flow edge case`() {
        handleTestCase("", true)
    }

    @Test
    fun `unhappy flow test 1`() {
        handleTestCase("abcdefga", false)
    }

    @Test
    fun `unhappy flow test 2`() {
        handleTestCase("abcdefga$%$", false)
    }

    @Test
    fun `unhappy flow test 3`() {
        handleTestCase("aabcdefga$%$", false)
    }

    fun handleTestCase(inputString: String, expectedOutput: Boolean) {
        if (expectedOutput) {
            assertTrue(Problem1.allUniqueChars(inputString))
            assertTrue(Problem1.allUniqueCharsWithoutAdditionalDatastructures(inputString))
        } else {
            assertFalse(Problem1.allUniqueChars(inputString))
            assertFalse(Problem1.allUniqueCharsWithoutAdditionalDatastructures(inputString))
        }
    }
}