# Problem

- [문제 링크](https://leetcode.com/problems/reverse-linked-list/)

<br>

Linked List 의 root 가 주어지면 뒤집은 Linked List 의 root 를 구하는 문제입니다.

<br><br>

# Solution

문제를 푸는 방법은 총 두가지가 있습니다.

재귀와 반복입니다.

처음에 생각할 수 있는 건 재귀인데 Linked List 의 꼬리까지 쭉 들어간 다음에 `node.next` 를 변경 하면서 다시 돌아오면 됩니다.

예제를 통해서 어떻게 바뀌는지 알아보겠습니다.

<br>

## 1. 초기 상태

리스트를 끝까지 들어가면 4 부터 시작하게 됩니다 (5 는 `head.next == null` 이라서 빠져나옴)

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/reverse-linked-list-1.png?raw=true)

<br>

## 2. head.next.next = head;

`head.next.next` 가 `head` 를 가리키게 만들어서 4 와 5 는 서로를 가리키게 됩니다. 

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/reverse-linked-list-2.png?raw=true)

<br>

## 3. head.next = null;

`head.next` 를 null 로 만들면서 가리키는 게 없도록 만듭니다.

여기서 헷갈리는 점이 생길 수 있는데 `head.next` 를 null 로 만드는건 5 노드를 없애는 게 아닙니다.

말 그대로 4 가 가리키는 노드를 없애는 것이고 5 노드는 여전히 존재하고 주소값도 존재합니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/reverse-linked-list-3.png?raw=true)

<br>

## 4. 첫 번째 함수를 빠져나올 때의 최종 모습

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/reverse-linked-list-4.png?raw=true)

<br>

## 5. 두 번째 함수는 다음과 같은 상태입니다.

4 노드가 가리키는 노드가 없기 때문에 NULL 노드를 가리킨다고 할 수 있습니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/reverse-linked-list-5.png?raw=true)

<br>

## 6. 두 번째 함수를 빠져나올 때의 최종 모습

여기까지 진행하면 `3 -> 4 -> 5` 가 `5 -> 4 -> 3` 으로 바뀐 사실을 알 수 있습니다.

이대로 처음 시작했던 루트 노드까지 반복하면 최종적으로 뒤집어진 Linked List 를 구할 수 있습니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/reverse-linked-list-6.png?raw=true)

<br><br>

# Java Code

```java
// 1. Recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode result = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return result;
    }
}

// 2. iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode parent = null;
        
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = parent;
            parent = current;
        }
        
        return parent;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        return head?.next?.let {
            reverseList(it).apply {
                head.next.next = head;
                head.next = null;
            }
        } ?: head
    }
}
```
