package chapter16

import kotlin.math.abs
import kotlin.math.min

object Problem6 {

    fun smallestDifference(l1: List<Int>, l2: List<Int>): Int {
        val sl1 = l1.sorted()
        val sl2 = l2.sorted()
        var smallestDiff = abs(sl2[0] - sl1[0])
        var i1 = 0
        var i2 = 0
        while (i1 < l1.size && i2 < l2.size) {
            smallestDiff = min(smallestDiff, abs(sl2[i2] - sl1[i1]))
            if (i1+1 >= l1.size && i2+1 >= l2.size) break
            if (i1+1 >= l1.size){
                i2++
                continue
            }
            if (i2+1 >= l2.size){
                i1++
                continue
            }
            if (abs(sl1[i1+1]-sl2[i2]) <= abs(sl1[i1]-sl2[i2+1])){
                i1++
            } else {
                i2++
            }
        }
        return smallestDiff
    }
}