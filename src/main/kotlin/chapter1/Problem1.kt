package chapter1

object Problem1 {

    fun allUniqueChars(input: String) : Boolean {
        val hashSet = HashSet<Char>()
        input.toCharArray().forEach {
            if (hashSet.contains(it)) return false
            else hashSet.add(it)
        }
        return true
    }

    fun allUniqueCharsWithoutAdditionalDatastructures(input: String) : Boolean{
        val charArray = input.toCharArray()
        for (i in input.indices){
            for (j in i+1 until input.length) {
                if (charArray[i] == charArray[j]) return false
            }
        }
        return true
    }
}