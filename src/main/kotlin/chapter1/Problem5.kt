package chapter1

import kotlin.math.abs

object Problem5 {

    fun String.isOneEditDistanceAwayFrom(other: String): Boolean {
        if (abs(this.length - other.length) > 1) return false
        var thisI = 0
        var otherI = 0
        var dist = 0
        while (thisI < this.length || otherI < other.length && dist <= 1) {
            when {
                (thisI > this.lastIndex) -> { //ADDITION/REMOVAL
                    otherI++
                    dist++
                }
                (otherI > other.lastIndex) -> { //ADDITION/REMOVAL
                    thisI++
                    dist++
                }
                (this[thisI] == other[otherI]) -> {
                    thisI++
                    otherI++
                }
                (thisI + 1 < this.length && this[thisI+1] == other[otherI]) -> { //ADDITION/REMOVAL
                    dist++
                    thisI+=2
                    otherI++
                }
                (otherI + 1 < other.length && this[thisI] == other[otherI+1]) -> { //ADDITION/REMOVAL
                    dist++
                    thisI++
                    otherI+=2
                }
                (thisI + 1 < this.length && otherI + 1 < other.length && this[thisI+1] == other[otherI+1]) -> { //REPLACEMENT
                    dist++
                    thisI+=2
                    otherI+=2
                }
                else -> return false
            }
        }
        return dist <= 1
    }
}