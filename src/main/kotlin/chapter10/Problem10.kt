package chapter10

import java.util.TreeSet

object Problem10 {

    class RankFromStream(){
        private val treeSet = TreeSet<Int>()

        //O(log(N)) operation
        fun track(num: Int){
            treeSet.add(num)
        }

        //O(N) operation since getting the headSet is O(1) but counting the elements in this set is O(N)
        fun getRankOfNumber(num: Int) : Int{
            return treeSet.headSet(num).size
        }
    }
}