package chapter5

import java.lang.Integer.max

object Problem3 {

    //Assumption: There is always at least one 0 to flip
    fun flipToWin(A: Int) : Int{
        var running1Count = 0
        var runningCountWithFlippedBit = 0
        var longestSequenceFound = 0
        for (i in 0..31) {
            if (getBit(A, i) != 0) {
                runningCountWithFlippedBit++
                running1Count++
                longestSequenceFound = max(longestSequenceFound, max(runningCountWithFlippedBit, running1Count))
            } else {
                //If 2 sequences can get merged
                if (i - 1 >= 0 && getBit(A, i-1) != 0 && i+1 <= 31 && getBit(A, i+1) != 0){
                    runningCountWithFlippedBit = running1Count + 1
                } else {
                    //Else try to extend the current sequence by 1
                    longestSequenceFound = max(longestSequenceFound, running1Count+1)

                    //If next sequence of 1's starts in front of this 0, try flipping the bit in front of it
                    if (i+1 <= 31 && getBit(A, i+1) != 0) {
                        runningCountWithFlippedBit = 1
                    } else {
                        runningCountWithFlippedBit = 0
                    }
                }
                running1Count = 0
            }
        }
        return longestSequenceFound
    }

    fun getBit(A: Int, i: Int) : Int{
        return (1 shl i) and A
    }
}