package chapter1

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem1Tests {

    @Test
    fun `String with unique characters test 1`() {
        handleTestCase("abcdefg", true)
    }

    @Test
    fun `String with unique characters test 2`() {
        handleTestCase("abcdefg@#$%.!", true)
    }

    @Test
    fun `String with unique characters edge case`() {
        handleTestCase("", true)
    }

    @Test
    fun `String with duplicate characters test 1`() {
        handleTestCase("abcdefga", false)
    }

    @Test
    fun `String with duplicate characters test 2`() {
        handleTestCase("abcdefga$%$", false)
    }

    @Test
    fun `tring with duplicate characters test 3`() {
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