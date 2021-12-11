package chapter16

object Problem10 {

    data class Person(val birth: Int, val death: Int) : Comparable<Person> {
        override fun compareTo(other: Person): Int {
            return other.death - this.death
        }
    }

    fun yearMostPeopleAlive(list: List<Person>, minYear: Int, maxYear: Int): Int {
        var deltas = MutableList<Int>(maxYear - minYear + 2) { 0 }
        list.forEach {
            deltas[it.birth - minYear]++
            deltas[it.death - minYear + 1]--
        }
        var peopleAlive = 0
        var maxPeopleAlive = 0
        var maxPeopleAliveYear = -1
        for (i in deltas.indices) {
            peopleAlive += deltas[i]
            if (peopleAlive > maxPeopleAlive) {
                maxPeopleAlive = peopleAlive
                maxPeopleAliveYear = minYear + i
            }
        }
        return maxPeopleAliveYear
    }
}