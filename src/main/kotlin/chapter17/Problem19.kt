package chapter17

object Problem19 {

    fun missingOne(list: List<Int>) : Int {
        val N = list.size+1
        val sum1toN = ((1+N)*N)/2
        return sum1toN - list.sum()
    }
}