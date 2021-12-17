package chapter17

import kotlin.math.max

object Problem18 {

    fun shortestSupersequence(shorter: List<Int>, longer: List<Int>) : Pair<Int, Int>?{
        val needed = HashSet(shorter)
        val got = HashSet<Int>()

        var start =  0
        var end = 0
        var best : Pair<Int, Int>? = null
        while (start < longer.size && end < longer.size) {
            if (start > end) break
            if (needed.isEmpty()) {
                if (best == null || end - start < best.second - best.first){
                    best = start to end
                }
                if (got.contains(longer[start])){
                    got.remove(longer[start])
                    needed.add(longer[start])
                    if (got.isEmpty()) {
                        start = max(start+1, end)
                        end = max(start, end)
                        continue
                    }
                    while(start < longer.size && !got.contains(longer[start])) {
                        start++
                        if(start>=end) end = start
                    }
                } else {
                    start++
                }
            } else {
                if(needed.contains(longer[end])){
                    needed.remove(longer[end])
                    got.add(longer[end])
                } else {
                    end++
                }
            }
        }
        return best
    }
}