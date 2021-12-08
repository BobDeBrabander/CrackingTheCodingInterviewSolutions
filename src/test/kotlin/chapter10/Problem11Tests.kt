package chapter10

import org.junit.Test
import kotlin.test.fail

class Problem11Tests {

    @Test
    fun `simple test`(){
        val list = listOf(1, 3, 5, 2, 4, 9, 0)
        val result = Problem11.peaksAndValleys(list)
        result.forEachIndexed{ index, value ->
            val prev = if (index - 1 >= 0) result[index-1] else null
            val next = if (index + 1 < result.size) result[index+1] else null
            if (prev != null && next != null) {
                if ((value in (prev + 1) until next) || (value in (next + 1) until prev)) fail("$value is not a peek or value because the arrangement is $prev $value $next")
            }
        }
    }
}