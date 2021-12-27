package chapter17

import chapter17.Problem17GoogleDoc.multiSearch
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Problem17Tests {

    @Test
    fun `simple test`() {
        val bigWord = "asklbaasdfkklasdhflkasdfhlkafnelkuceueal"
        val smallWordsOut = listOf("aflek", "fadk", "dfka", "adfds", "abcdfe")
        val smallWordsIn = listOf("baas", "kafne", "dhf", "uea", "kk", "skl")
        val wordsTogether = smallWordsIn+smallWordsOut

        val result = multiSearch(bigWord, wordsTogether)
        assertThat(result).containsExactlyInAnyOrderElementsOf(smallWordsIn)
    }
}