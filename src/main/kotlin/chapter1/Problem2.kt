package chapter1

object Problem2 {

    fun String.permutationOf(otherString: String) : Boolean {
        return this.toCharArray().sorted() == otherString.toCharArray().sorted()
    }
}