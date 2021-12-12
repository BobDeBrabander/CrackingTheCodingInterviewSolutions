package chapter17

import kotlin.random.Random

object Problem3 {

    fun randomSet(list: List<Int>, m: Int): Set<Int> {
        val listCopy = list.toMutableList()
        var resultSet = mutableSetOf<Int>()
        while (listCopy.isNotEmpty() && resultSet.size < m) {
            val rand = Random.nextInt(listCopy.size)
            resultSet.add(listCopy.removeAt(rand))
        }
        return resultSet
    }
}