package chapter16

object Problem18 {

    fun matchesPattern(value: String, pattern: String): Boolean {
        if (pattern.isBlank()) return false
        val countA = pattern.count { it == 'a' }
        val countB = pattern.count { it == 'b' }

        val possibleAlen = mutableListOf<Int>()
        val possibleBlen = mutableListOf<Int>()
        val valLen = value.length
        when {
            countA == 0 -> {
                if (valLen % countB != 0) return false
                val patLen = valLen / countB
                val pat = value.substring(0, patLen)
                return pat.repeat(countB) == value
            }
            countB == 0 -> {
                if (valLen % countA != 0) return false
                val patLen = valLen / countA
                val pat = value.substring(0, patLen)
                return pat.repeat(countA) == value
            }
            else -> {
                for (i in 1..(valLen / countA)) {
                    if ((valLen - (i * countA)) % countB == 0) {
                        possibleAlen.add(i)
                        possibleBlen.add((valLen - (i * countA)) / countB)
                    }
                }
                for (i in possibleAlen.indices) {
                    val firstA = pattern.indexOf('a')
                    val firstB = pattern.indexOf('b')
                    val aLen = possibleAlen[i]
                    val bLen = possibleBlen[i]
                    val startOfA = firstA * bLen //if a starts this is 0
                    val startOfB = firstB * aLen //if b starts this is 0
                    var aPattern = value.substring(startOfA, startOfA + aLen)
                    var bPattern = value.substring(startOfB, startOfB + bLen)
                    val sb = StringBuilder()
                    pattern.forEach {
                        if (it == 'a') sb.append(aPattern)
                        else sb.append(bPattern)
                    }
                    if (sb.toString() == value) return true
                }
            }
        }
        return false
    }
}