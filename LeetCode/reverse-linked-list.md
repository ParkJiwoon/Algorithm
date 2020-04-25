# Problem

- [문제 링크](https://leetcode.com/problems/reverse-linked-list/)

<br>

난이도 *__Easy__* 문제입니다.

`Singly-Linked List` 가 주어지면 뒤집어진 `Singly-Linked List` 를 리턴하면 됩니다.

<br><br>

# Solution

`ListNode` 를 그대로 순회하면서 꼬리부터 만들어서 머리를 이어붙인다고 생각하면 됩니다.

<br><br>

# Java Code

```java
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
```