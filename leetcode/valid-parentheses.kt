/**
 * 문제: https://leetcode.com/problems/valid-parentheses
 * 풀이:https://bcp0109.tistory.com/125
 */
 
import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        s.forEach {
            when (it) {
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
                else -> stack.push(it)
            }
        }

        return stack.isEmpty()
    }
}
