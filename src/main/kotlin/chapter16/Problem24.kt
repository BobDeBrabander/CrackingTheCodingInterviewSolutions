package chapter16

import kotlin.math.max
import kotlin.math.min

object Problem24 {

    fun pairsWithSum(list: List<Int>, desiredSum: Int) : Set<Pair<Int, Int>>{
        //map of i -> c meaning i occurs c times in the list
        val elementCount = list.groupBy { it }
            .map { (key, value) -> key to value.size }
            .toMap()

        val foundPairs = mutableSetOf<Pair<Int, Int>>()
        elementCount.forEach { (element, occurrence) ->
            val required = desiredSum - element
            when {
                required == element -> if (occurrence > 1) foundPairs.add(element to element)
                elementCount.containsKey(required) -> foundPairs.add(min(element,required) to max(element,required))
            }
        }
        return foundPairs
    }
}