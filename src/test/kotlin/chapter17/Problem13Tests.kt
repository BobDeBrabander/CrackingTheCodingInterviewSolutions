package chapter17

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem13Tests {

    @Test
    fun `example test`(){
        val unspacedString = "jesslookedjustliketimherbrother"
        val listOfWords = listOf("looked", "just", "like", "her", "brother")
        val result = Problem13.reSpace(unspacedString, listOfWords)
        val expect = "jess looked just like tim her brother"
        assertThat(result).isEqualTo(expect)
    }
}