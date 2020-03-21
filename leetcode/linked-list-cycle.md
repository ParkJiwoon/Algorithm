# Problem

- [문제 링크](https://leetcode.com/problems/linked-list-cycle/)

<br>

난이도 *__Easy__* 문제입니다.

`ListNode` 가 주어지면 싸이클 여부를 판단해서 `true`, `false` 로 리턴해주면 됩니다.

<br><br>

# Solution

리스트의 길이가 얼마나 될지 알 수 없어서 배열을 쓰기는 힘들고

`Map`, `Set` 자료구조를 이용하여 중복 체크를 하는 방식으로 답을 구할 수도 있습니다.

단, 그렇게 구한다면 `Node` 의 `val` 값이 중복 될 수 있으므로 `ListNode` 자체를 `Map` 이나 `Set` 에 저장해야 해서 비효율적입니다.

효율적으로 푸려면 토끼와 거북이 알고리즘을 이용하면 됩니다.

토끼와 거북이 알고리즘은 이름 그대로입니다.

두칸씩 이동하는 토끼와 한칸씩 이동하는 거북이가 같은 출발점에서 시작합니다.

만약 싸이클이 존재한다면 둘은 같은 싸이클을 돌면서 언젠가 만나게 됩니다.

싸이클이 존재하지 않는다면 토끼가 먼저 끝에 도달하여 리스트가 끝나게 됩니다.

원래는 싸이클이 시작하는 위치를 찾아내는 것까지 토끼와 거북이 알고리즘이라고 할 수 있지만

이 문제에서는 싸이클 여부만 판단하면 되기 때문에 생략하겠습니다.

<br><br>

# Java Code

```java
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
```