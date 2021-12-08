package chapter10

object Problem1 {

    //A has exactly enough room behind it to fit B
    //Both A and B are sorted in ascending order
    fun mergeBIntoA(A: MutableList<Int>, B: List<Int>){
        var indexB = B.size-1
        var indexA = A.size-B.size-1
        var pointerFill = A.size-1
        while(indexB >= 0) {
            when {
                indexB < 0 -> {
                    A[pointerFill] = A[indexA]
                    indexA--
                }
                indexA < 0 || A[indexA] < B[indexB]-> {
                    A[pointerFill] = B[indexB]
                    indexB--
                }
                else -> {
                    A[pointerFill] = A[indexA]
                    indexA--
                }
            }
            pointerFill--
        }
    }
}