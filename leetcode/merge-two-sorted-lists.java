/**
 * 문제: https://leetcode.com/problems/merge-two-sorted-lists/
 * 풀이: https://bcp0109.tistory.com/126
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            
            node = node.next;
        }
        
        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }
        
        return result.next;
    }
}
