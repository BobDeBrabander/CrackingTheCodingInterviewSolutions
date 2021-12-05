package chapter8

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.Stack

class Problem6Tests {

    @Test
    fun `simple test`(){
        val s1 = Stack<Int>()
        s1.push(5)
        s1.push(4)
        s1.push(3)
        s1.push(2)
        s1.push(1)

        val s2 = Stack<Int>()
        val s3 = Stack<Int>()
        Problem6.towerOfHanoi(s1, s2, s3)

        assertThat(s1).isEmpty()
        assertThat(s2).isEmpty()
        assertThat(s3.toList()).isEqualTo(listOf(5, 4, 3, 2, 1))
    }
}