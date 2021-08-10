package chapter1

import kotlin.math.abs

object Problem5 {

    fun oneEditAway(string1: String, string2: String): Boolean {
        if (abs(string1.length - string2.length) > 1) return false
        var i1 = 0
        var i2 = 0
        var diffFound = false
        val s1 = if (string1.length < string2.length) string1 else string2
        val s2 = if (string1.length < string2.length) string2 else string1
        //Now s1 is the shorter string is they are different length

        while (i1 < s1.length && i2 < s2.length) {
            when {
                s1[i1] == s2[i2] -> {
                    i1++
                    i2++
                }
                diffFound -> return false
                s1.length == s2.length -> {
                    diffFound = true
                    i1++
                    i2++
                }
                else -> {
                    //move only the longer index
                    diffFound = true
                    i2++
                }
            }
        }
        return true
    }
}