package chapter1

import chapter1.Problem3.URLify
import org.junit.Test
import kotlin.test.assertEquals

class Problem3Tests {

    @Test
    fun `Normal test 1`(){
        handleTestCase("Mr John Smith    ", 13, "Mr%20John%20Smith")
    }

    @Test
    fun `Normal test 2`(){
        handleTestCase("A lot of extra spaces        ", 21, "A%20lot%20of%20extra%20spaces")
    }

    @Test
    fun `edge case`(){
        handleTestCase("Mr", 2, "Mr")
    }

    @Test
    fun `edge case 2`(){
        handleTestCase("   ", 1, "%20")
    }

    fun handleTestCase(inputString: String, inputLength: Int, expectedOutput: String){
        assertEquals(URLify(inputString, inputLength), expectedOutput)
    }
}