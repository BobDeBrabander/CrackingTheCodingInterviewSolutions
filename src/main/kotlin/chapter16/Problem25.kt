package chapter16

object Problem25 {

    class LRUCache(private val capacity: Int) {

        private val linkedHashMap = LinkedHashMap<String, Int>(capacity)

        fun addEntry(key: String, entry: Int) {
            if (linkedHashMap.containsKey(key)) {
                linkedHashMap.remove(key)
                linkedHashMap[key] = entry
                //removing instead of overwriting so its is put at the end of the list of uses again
            } else {
                if (linkedHashMap.size == capacity) {
                    val oldestKey = linkedHashMap.entries.first().key
                    linkedHashMap.remove(oldestKey)
                }
                linkedHashMap[key] = entry
            }
        }

        fun removeEntry(key: String) = linkedHashMap.remove(key)

        fun getEntry(key: String): Int? = linkedHashMap[key]

        fun containsKey(key: String): Boolean = linkedHashMap.containsKey(key)
    }
}