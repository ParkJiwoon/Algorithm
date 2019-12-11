/**
 * 문제: https://leetcode.com/problems/reverse-linked-list/
 * 풀이: https://bcp0109.tistory.com/142
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode child = null;
        ListNode parent = null;
        
        while (head != null) {
            parent = new ListNode(head.val);
            parent.next = child;
            child = parent;
            head = head.next;
        }
        
        return parent;
    }
}
