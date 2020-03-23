# Problem

- [문제 링크](https://leetcode.com/problems/merge-two-sorted-lists/)

<br>

난이도 *__Easy__* 문제입니다.

`Input` 으로 두 `ListNode` 를 받으면 합쳐서 오름차순으로 정리된 `ListNode` 를 `return` 하면 됩니다.

<br><br>

# Solution 1

`while` 문을 돌면서 작은 값을 넣어주며 만들면 됩니다.

`l1`, `l2` 중에 하나가 `null` 이 될때까지 비교하며 넣어줍니다.

`while` 문이 끝나면 둘 중 하나가 `null` 이라는 뜻이기 때문에 둘 중 `null` 이 아닌 `ListNode` 를 그대로 전부 붙이면 됩니다.

<br><br>

# Java Code 1

```java
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
```

<br><br>

# Solution 2

문제를 푼 후에 **Discuss**를 찾아보니 재귀로 푼 사람이 있었습니다.

`return` 값이 `ListNode` 라는 걸 이용해서 재귀로 계속해서 뒤에 붙이는 풀이입니다.

<br><br>

# Java Code 2

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```