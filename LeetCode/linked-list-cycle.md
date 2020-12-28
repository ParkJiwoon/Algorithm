# Problem

- [문제 링크](https://leetcode.com/problems/linked-list-cycle/)

<br>

주어진 리스트 노드가 싸이클을 형성하는 지 찾는 문제입니다.

<br><br>

# Solution

토끼와 거북이 알고리즘을 응용하면 됩니다.

주어진 노드를 `fast` 와 `slow` 에 옮겨담습니다.

`fast` 노드는 2 씩 움직이고 `slow` 노드는 1 씩 움직입니다.

싸이클이 존재한다면 `fast` 와 `slow` 는 싸이클에 빠져서 무한히 반복되는데, `fast` 노드가 `slow` 노드보다 1 씩 빠르기 때문에 거리가 1 씩 줄어들어 언젠가는 만나게 됩니다.

만약 앞서 나가던 `fast` 노드가 `null` 을 마주친다면 싸이클이 존재하지 않는 거라서 `false` 를 리턴하면 됩니다.

<br>

# Java Code

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                return true;
            }
        }
        
        return false;
    }
}
```
