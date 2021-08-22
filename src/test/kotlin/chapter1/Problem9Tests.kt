package chapter1

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem9Tests {

    @Test
    fun `simple rotation test true`(){
        handleCase("waterbottle", "erbottlewat", true)
    }

    @Test
    fun `simple rotation test true 2`(){
        handleCase("kaas", "aask", true)
    }

    @Test
    fun `simple rotation test false`(){
        handleCase("waterbottle", "bottlewat", false)
    }

    @Test
    fun `simple rotation test false 2`(){
        handleCase("hond", "katt", false)
    }

    fun handleCase(s1: String, s2: String, expectedOutcome: Boolean){
        if (expectedOutcome){
            assertTrue(Problem9.isRotation(s1, s2))
        } else {
            assertFalse (Problem9.isRotation(s1, s2))
        }

    }
}