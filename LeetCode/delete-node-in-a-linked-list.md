# Problem

- [문제 링크](https://leetcode.com/problems/delete-node-in-a-linked-list/)

<br>

완성된 Linked List 가 이미 존재하면 입력으로 주어진 Node 를 삭제하면 됩니다.

<br><br>

# Solution

처음에는 이해가 잘 안될 수도 있는데 Linked List 는 이미 존재하고 Input 으로 주어지는 건 삭제될 Node 한 개 뿐입니다.

처음에는 단순하게 `node = node.next` 로 하려고 했으나.. 

현재 Node 의 부모 노드를 prevNode 라고 할 때 `prevNode.next` 가 가리키고 있는 건 node 의 주소 값입니다.

그래서 현재 node 에 node.next 를 덮어 씌우더라도 `prevNode.next` 는 여전히 원래의 주소 값을 가리키고 있어서 변경되지 않습니다.

현재 노드의 주소를 변경하지 않은 채로 `val` 과 `next` 를 변경해주면 풀립니다.

문제 설명에 주어지는 노드는 `tail node` 가 아니라는 조건이 있기 때문에 별다른 예외처리는 필요 없습니다.

<br><br>

# Java Code

```java
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`
        node?.next = node?.next?.next
    }
}
```
