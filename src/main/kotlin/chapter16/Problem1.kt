package chapter16

object Problem1 {

    fun swapNumbersInPlace(num1: Int, num2: Int){
        var n1 = num1
        var n2 = num2

        n1 = n1 xor n2 //n1 xor n2
        n2 = n1 xor n2 //(n1 xor n2) xor n2 = n1
        n1 = n1 xor n2 //(n1 xor n2) xor n1 = n2
        //swapped
    }
}