package chapter5

import org.junit.Test
import kotlin.test.assertEquals

class Problem8Tests {

    @Test
    fun `Simple testcase`() {
        val screen = Problem8.Screen(24, 3)
        screen.drawLine(4, 20, 1)

        //First row has no line
        assertEquals(0, screen.screen[0])
        assertEquals(0, screen.screen[1])
        assertEquals(0, screen.screen[2])

        //Middle row has a line
        //First byte has 00001111
        assertEquals(15, screen.screen[3])

        //Middle byte is all line
        assertEquals(-1, screen.screen[4])

        //Last byte has 11111000
        assertEquals(-8, screen.screen[5])

        //Last row has no line
        assertEquals(0, screen.screen[6])
        assertEquals(0, screen.screen[7])
        assertEquals(0, screen.screen[8])
    }

}