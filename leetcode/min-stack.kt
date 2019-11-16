// https://leetcode.com/problems/min-stack/submissions/

import java.util.*

class MinStack() {

    /** initialize your data structure here. */
    private var min: Int = Int.MAX_VALUE
    val stack = Stack<Int>()

    fun push(x: Int) {
        if (x <= min) {
            stack.push(min)
            min = x
        }
        stack.push(x)
    }

    fun pop() {
        if (stack.pop() == min) {
            min = stack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return min
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
