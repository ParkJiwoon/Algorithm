# Problem

- [문제 링크](https://leetcode.com/problems/merge-two-sorted-lists/)

<br>

두 `ListNode` 를 받으면 합쳐서 오름차순으로 정리된 `ListNode` 를 return 하면 됩니다.

<br><br>

# Solution

return 값이 `ListNode` 라는 걸 이용해서 재귀로 뒤에 붙이면 됩니다.

<br><br>

# Java Code

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

<br>

# Kotlin Code

```kotlin
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? = when {
        l1 == null -> l2
        l2 == null -> l1
        l1.`val` < l2.`val` -> l1.apply { next = mergeTwoLists(l1.next, l2) }
        else -> l2.apply { next = mergeTwoLists(l1, l2.next) }
    }
}
```
