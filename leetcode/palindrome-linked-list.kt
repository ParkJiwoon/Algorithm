/**
 * 문제: https://leetcode.com/problems/palindrome-linked-list
 * 풀이: https://bcp0109.tistory.com/129
 */
 
 class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
        
        val list = ArrayList<Int>()
        var node = head
            
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
        
        val len = list.size
        for (i in 0..(len/2)) {
            if (list[i] != list[len-1-i]) {
                return false
            }
        }
        
        return true
    }
}
