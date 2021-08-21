package chapter1

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem9Tests {

    @Test
    fun `simple rotation test true`(){
        handleCase("waterbottle", "erbottlewat", true)
    }

    fun handleCase(s1: String, s2: String, expectedOutcome: Boolean){
        if (expectedOutcome){
            assertTrue(Problem9.isRotation(s1, s2))
        } else {
            assertFalse (Problem9.isRotation(s1, s2))
        }

    }
}