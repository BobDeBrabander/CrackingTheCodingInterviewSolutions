package chapter8

import java.util.Stack

object Problem6 {

    fun towerOfHanoi(s1: Stack<Int>, s2: Stack<Int>, s3: Stack<Int>){
        towerOfHanoi(s1.size, s1, s2, s3)
    }

    fun towerOfHanoi(n: Int, from: Stack<Int>, aux: Stack<Int>, to: Stack<Int>){
        if (n == 1) {
            to.push(from.pop())
            return
        }
        towerOfHanoi(n-1, from, to, aux) //First move the top n-1 tower over to the auxiliary-stack
        to.push(from.pop()) //Then put the biggest disk to the to-stack
        towerOfHanoi(n-1, aux, from, to) //then build this auxiliary stack back on top of the to-stack
    }
}