package chapter1

object Problem2 {

    fun String.permutationOf(otherString: String) : Boolean {
        val hashMap = HashMap<Char, Int>()
        this.forEach { c ->
            hashMap[c] = hashMap[c]?.let{it + 1} ?: 1
        }
        otherString.forEach { c ->
            val hashMapVal = hashMap[c]
            if (hashMapVal == null) return false
            else {
                if (hashMapVal == 1) hashMap.remove(c)
                else hashMap[c] = hashMapVal - 1
            }
        }
        return true
    }
}