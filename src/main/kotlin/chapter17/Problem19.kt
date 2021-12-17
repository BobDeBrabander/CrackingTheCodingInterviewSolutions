package chapter17

object Problem19 {

    fun missingOne(list: List<Int>) : Int {
        val N = list.size+1
        val sum1toN = ((1+N)*N)/2
        return sum1toN - list.sum()
    }

    fun missingTwo(list: List<Int>) : List<Int> {
        val N = list.size+2
        val sum1ToN = ((1+N)*N)/2
        val listSum = list.sum()
        val difference = sum1ToN - listSum
        val sortedList = list.sorted()
        for(i in sortedList.indices){
            if (sortedList[i] != i+1) return listOf(i+1, difference-(i+1))
        }
        return listOf()
    }
}