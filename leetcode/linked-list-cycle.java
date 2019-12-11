/**
 * 문제: https://leetcode.com/problems/linked-list-cycle/
 * 풀이: https://bcp0109.tistory.com/141
 */ 
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}
