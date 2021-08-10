package chapter1

object Problem4 {

    //Assumption: spaces should be ignored
    //Assumption2: characters should be made lowercase first
    fun String.isPermutationOfPalindrome(): Boolean {
        //There can maximum be one character with an odd amount of occurrences in this string
        //Otherwise it could never be a palindrome
        val hashSet = HashSet<Char>()
        this.lowercase()
                .filter { it != ' ' }
                .forEach {
                    if (hashSet.contains(it)) hashSet.remove(it)
                    else hashSet.add(it)
                }
        return hashSet.size <= 1
    }
}