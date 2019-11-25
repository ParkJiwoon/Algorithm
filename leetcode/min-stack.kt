/**
 * 문제: https://leetcode.com/problems/min-stack
 * 풀이: https://bcp0109.tistory.com/128
 */

// Using PriorityQueue
import java.util.*

class MinStack() {
    val normal = Stack<Int>()
    val minimum = PriorityQueue<Int>()

    fun push(x: Int) {
        normal.push(x)
        minimum.add(x)
    }

    fun pop() {
        minimum.remove(normal.pop())
    }

    fun top(): Int {
        return normal.peek()
    }

    fun getMin(): Int {
        return minimum.peek()
    }
}



// O(1..n-1) space
import java.util.*

class MinStack() {
    val normal = Stack<Int>()
    var minimum = Int.MAX_VALUE

    fun push(x: Int) {
        if (x <= minimum) {
            normal.push(minimum)
            minimum = x
        }
        
        normal.push(x)
    }

    fun pop() {
        if (normal.pop() == minimum) {
            minimum = normal.pop()
        }
    }

    fun top(): Int {
        return normal.peek()
    }

    fun getMin(): Int {
        return minimum
    }
}
