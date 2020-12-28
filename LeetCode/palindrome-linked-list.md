# Problem

- [문제 링크](https://leetcode.com/problems/palindrome-linked-list/)

<br>

주어진 리스트 노드가 Palindrome 을 만족하는 지 확인하는 문제입니다.

`O(n) time and O(1) space` 에 해결하라는 조건이 있습니다.

<br><br>

# Solution

추가 공간복잡도를 많이 사용하면 안되기 때문에 리스트 노드를 직접 조작해야 합니다.

원래는 리스트 노드 전체를 뒤집은 새 리스트 노드를 만들어 비교하려 했으나 이러면 `O(n)` 공간복잡도를 사용하게 됩니다.

어쩔 수 없이 직접 중간 지점을 찾아서 뒤집은 후에 직접 비교하면 됩니다.

주의할 점은 전체 길이가 홀수일 때 정가운데 있는 숫자는 비교할 필요가 없으므로 `slow` 를 한칸 더 이동시키는 것과 비교하는 `while (head != null)` 대신 `while (tail != null)` 값을 사용해야 하는 겁니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        
        // slow 를 중간 지점까지 이동
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // 전체 길이가 홀수면 한칸 더 이동 (가운데 값은 비교할 필요 없음)
        if (fast != null) slow = slow.next;
        
        // 중간부터 마지막까지 노드 순서 뒤집기
        ListNode tail = reverse(slow);
        
        while (tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            
            head = head.next;
            tail = tail.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode tail = null;
        
        while (node != null) {
            ListNode next = node.next;
            node.next = tail;
            tail = node;
            node = next;
        }
        
        return tail;
    }
}
```
