package chapter1

object Problem9 {

    fun isRotation(s1: String, s2: String) : Boolean{
        if (s1.length != s2.length) return false
        val s1s1 = s1 + s1
        return s1s1.contains(s2) //checks for substring
    }
}