package chapter5

object Problem1 {

    //Insert M into N
    //M needs to start at position i and end at position j
    //i < j but we read from right to left in this case
    //N will have at least |M| space between i and j
    //I assume inserting means strict overwriting
    fun solve(N: Int, M: Int, i: Int, j: Int) : Int{
        //Create a mask that has 0's from i to j
        val mask = (-1 shl j) xor (-1 ushr (32 - i))
        return (N and mask) xor (M shl i)
    }
}