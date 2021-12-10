package chapter16

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Problem25Tests {

    @Test
    fun `simple test`(){
        val cache = Problem25.LRUCache(3)
        cache.addEntry("dog", 1)
        cache.addEntry("cat", 2)
        cache.addEntry("person", 3)
        cache.addEntry("dog", 2)
        cache.addEntry("cheese", 1)

        assertTrue(cache.containsKey("dog"))
        assertTrue(cache.containsKey("cheese"))
        assertTrue(cache.containsKey("person"))
        assertFalse(cache.containsKey("cat"))
    }
}