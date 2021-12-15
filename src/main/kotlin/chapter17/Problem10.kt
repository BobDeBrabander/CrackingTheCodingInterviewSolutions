package chapter17

object Problem10 {

    //list only has positive elements
    fun majorityElement(list: List<Int>): Int {
        val candidate = getCandidate(list)
        if (validate(list, candidate)) return candidate
        return -1
    }

    private fun getCandidate(list: List<Int>): Int {
        var curCandidate = list[0]
        var match = 1
        var notMatch = 0

        for (i in 1 until list.size) {
            if (match <= notMatch) {
                curCandidate = list[i]
                match = 1
                notMatch = 0
                continue
            } else {
                if (list[i] == curCandidate) match++
                else notMatch++
            }
        }

        return curCandidate
    }

    private fun validate(list: List<Int>, element: Int): Boolean {
        return list.count { it == element } > (list.size / 2)
    }
}