package chapter1

import chapter1.Problem6.compressString
import org.junit.Test
import kotlin.test.assertEquals

class Problem6Tests {

    @Test
    fun `compress string example case`(){
        handleTestCase("aabcccccaaa", "a2b1c5a3")
    }

    @Test
    fun `return compressed variant case 1`(){
        handleTestCase("aaaabbbcc", "a4b3c2")
    }

    @Test
    fun `compress return original case 1`(){
        handleTestCase("abbbcc", "abbbcc")
    }

    @Test
    fun `compress return original case 2`(){
        handleTestCase("aabbcc", "aabbcc")
    }

    @Test
    fun `edge case 1`(){
        handleTestCase("", "")
    }

    @Test
    fun `edge case 2`(){
        handleTestCase("a", "a")
    }

    fun handleTestCase(inputString: String, expectedOutput: String){
        assertEquals(expectedOutput, compressString(inputString))
    }

}