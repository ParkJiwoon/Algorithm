# Problem

- [문제 링크](https://leetcode.com/problems/intersection-of-two-linked-lists/)

<br>

리스트 두 개가 주어졌을 때 두 리스트의 겹치는 부분의 `HeadNode` 를 리턴하는 문제입니다.

<br><br>

# Solution

이 문제에서 핵심은 `두 리스트의 길이가 다를 때도 O(N) 시간복잡도에 O(1) 공간복잡도에 구해야 한다`는 점입니다.

<br>

원래라면 힘들겠지만 가능하도록 만드는 문제의 조건이 여러개 있습니다.

1. A 리스트와 B 리스트의 중복된 부분은 값만 중복되는 게 아니라 주소값 자체가 중복된다.
2. 이 문제에서 만들어지는 모든 리스트는 싸이클이 형성되지 않는다.

<br>

간단히 코드 설명을 하면 다음과 같습니다.

각 헤드 노드를 `a, b` 변수에 담습니다.

`while` 문으로 `a != b` 여부를 확인하면서 노드 순회를 진행합니다.

1 번 조건으로 인해 값을 직접 비교하지 않고 주소값을 비교해도 일치 여부를 확인할 수 있습니다.

각 리스트가 끝에 도달하면 **다른 리스트의 헤드로 이동합니다**

그리고 마찬가지로 노드를 계속 순회하고 끝에 도달하는 순간 종료됩니다.

<br>

이렇게 하면 두 리스트의 길이가 달라도 A+B 의 길이는 같기 때문에 동일하게 비교할 수 있습니다.

간단하게 문자로 표현해봅니다.

```html
A: a1 -> a2 -> a3 -> c1 -> c2
B: b1 -> b2 -> c1 -> c2

while 문으로 비교
a1 -> a2 -> a3 -> c1 -> c2 -> b1 -> b2 -> c1 -> c2 -> null
b1 -> b2 -> c1 -> c2 -> a1 -> a2 -> a3 -> c1 -> c2 -> null
```

<br>

2 번 조건으로 문제에서 등장하는 모든 노드는 싸이클이 형성되지 않기 때문에 무조건 마지막에 둘 다 `null` 값이 되며 반복분이 종료됩니다.

<br><br>

# Java Code

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
				ListNode a = headA, b = headB;
        
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }
}
```
