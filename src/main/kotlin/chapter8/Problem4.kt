package chapter8

object Problem4 {

    fun powerSet(set: Set<Int>) : List<Set<Int>>{
        val answer = mutableListOf<Set<Int>>()
        answer.add(set)
        set.forEach {
            val setCopy = set.toMutableSet()
            setCopy.remove(it)
            answer.addAll(powerSet(setCopy))
        }
        return answer
    }
}