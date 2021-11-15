package chapter5

object Problem2 {

    fun doubleToBinary(d: Double){
        var counter = 0
        var curNum = d
        //shifting the numbers behind the decimal pointer to the front
        while(counter < 9 && curNum.toInt().toDouble() != curNum){
            curNum *= 10
            counter++
        }
        if (curNum.toInt().toDouble() != curNum) throw Exception("Not possible to convert to binary")
        println(Integer.toBinaryString(curNum.toInt()))
    }
}