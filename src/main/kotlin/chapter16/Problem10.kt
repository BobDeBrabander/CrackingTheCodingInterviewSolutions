package chapter16

import java.util.TreeSet

object Problem10 {

    data class Person(val birth: Int, val death: Int) : Comparable<Person> {
        override fun compareTo(other: Person): Int {
            return other.death - this.death
        }
    }

    fun yearMostPeopleAlive(list: List<Person>) : Int {
        val peopleGroupedByBirthYear = list.groupBy { it.birth }
        val queueByDeathYear = TreeSet<Person>()
        var maxPeopleAlive = 0
        var maxPeopleAliveYear = -1

        for (i in 1900..2000){
            queueByDeathYear.addAll(peopleGroupedByBirthYear[i] ?: listOf())
            while(queueByDeathYear.firstOrNull()?.death ?: Int.MIN_VALUE > i) queueByDeathYear.pollFirst()
            if (maxPeopleAlive < queueByDeathYear.size) {
                maxPeopleAlive = queueByDeathYear.size
                maxPeopleAliveYear = i
            }
        }
        return maxPeopleAliveYear
    }
}