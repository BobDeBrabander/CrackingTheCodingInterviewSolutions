package chapter8

import org.junit.Test
import kotlin.test.assertEquals

class Problem13Tests {

    @Test
    fun `simple test`() {
        val box1 = Problem13.Box(12, 8, 10)
        val box2 = Problem13.Box(8, 7, 5)
        val box3 = Problem13.Box(4, 8, 5)
        val box4 = Problem13.Box(20, 12, 11)
        val box5 = Problem13.Box(7, 6, 4)
        val box6 = Problem13.Box(14, 5, 7)
        val boxes = listOf(box1, box2, box3, box4, box5, box6)

        val expected = 12 + 8 + 7 + 6 //box4.height + box1.height + box2.height + box5.height
        assertEquals(expected, Problem13.largestStack(boxes))
    }
}