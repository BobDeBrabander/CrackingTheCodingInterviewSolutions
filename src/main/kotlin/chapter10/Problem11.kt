package chapter10

object Problem11 {

    fun peaksAndValleys(list: List<Int>) : List<Int>{
        val mutableList = list.sorted().toMutableList()
        for (i in 0 until mutableList.size step 2){
            if (i+1 < mutableList.size){
                val temp = mutableList[i]
                mutableList[i] = mutableList[i+1]
                mutableList[i+1] = temp
            }
        }
        return mutableList.toList()
    }

}