package chapter16

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem18Tests {

    @Test
    fun `example test`(){
        val value = "catcatgocatgo"
        val pattern = "aabab"
        val result = Problem18.matchesPattern(value, pattern)
        val expect = true
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test false 1`(){
        val value = "catcatgocatgo"
        val pattern = "abab"
        val result = Problem18.matchesPattern(value, pattern)
        val expect = false
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test false 2`(){
        val value = "catcatgogo"
        val pattern = "abab"
        val result = Problem18.matchesPattern(value, pattern)
        val expect = false
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `simple test true 1`(){
        val value = "catcatgogo"
        val pattern = "aabb"
        val result = Problem18.matchesPattern(value, pattern)
        val expect = true
        assertThat(result).isEqualTo(expect)
    }
}