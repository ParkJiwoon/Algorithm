# Problem

- [문제 링크](https://leetcode.com/problems/odd-even-linked-list/)

<br>

주어진 링크드 리스트를 홀수 번째 노드를 앞으로 짝수 번째 노드를 뒤로 하는 링크드 리스트를 만드는 문제입니다.

<br><br>

# Solution

단순하게 반복하면 됩니다.

홀수 번째 노드를 순회하는 `odd` 와 짝수 번째 노드를 순회하는 `even` 노드를 선언합니다.

짝수 노드의 헤드는 `evenHead` 에 따로 저장해두고 `odd` 와 `even` 을 끝까지 이동시킵니다.

그리고 `while` 문이 끝난 후에는 `odd` 는 가장 마지막 값이기 때문에 `evenHead` 를 붙이고 맨 처음 저장된 `head` 를 리턴하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        
        ListNode odd = head, even = head.next, evenHead = even;
        
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
    }
}
```
