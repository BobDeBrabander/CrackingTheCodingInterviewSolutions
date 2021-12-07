package chapter10

object Problem2 {

    fun groupAnagrams(list: List<String>) : List<String>{
        return list.sortedBy { it.toCharArray().sorted().toString()+it }
    }
}