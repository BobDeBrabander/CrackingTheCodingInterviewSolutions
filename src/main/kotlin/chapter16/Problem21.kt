package chapter16

object Problem21 {

    fun sumSwap(l1: List<Int>, l2: List<Int>): Pair<Int, Int>? {
        val sum1 = l1.sum()
        val sum2 = l2.sum()
        val diff = sum2 - sum1 //How much to add to l1 to make it l2
        if (diff % 2 != 0) return null //We can't make the sums the same as they differ an odd amount
        val diffToAddTo1 = diff / 2
        val hs2 = HashSet<Int>()
        hs2.addAll(l2)
        l1.forEach {
            if (hs2.contains(diffToAddTo1 + it)) return it to (diffToAddTo1 + it)
        }
        return null
    }
}