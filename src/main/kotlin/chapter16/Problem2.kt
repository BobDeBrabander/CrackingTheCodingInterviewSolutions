package chapter16

object Problem2 {

    class Book(val list: List<String>) {
        val frequencyMap = HashMap<String, Int>()

        init {
            list.forEach {
                if (frequencyMap.containsKey(it)) frequencyMap[it] = frequencyMap[it]!! + 1
                else frequencyMap[it] = 1
            }
        }

        fun frequenceOf(word: String) = frequencyMap.getOrDefault(word, 0)
    }
}