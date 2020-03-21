# Problem

- [문제 링크](https://leetcode.com/problems/add-two-numbers/)

<br>

*__Medium__* 문제입니다. (체감 난이도는 *__Easy__*)

두 리스트를 받아서 더하기만 하면 되는 문제입니다.

<br><br>

# Solution 1

각 노드에는 *음수가 아닌 한 자리의 정수*가 있으며 *각 자리의 숫자가 거꾸로* 되어 있습니다.

따라서 `l1, l2` 를 순서대로 비교하면서 더해주고 10 이상인 경우 `carry` 를 다음 노드로 넘기면 됩니다.

`l1, l2` 의 길이가 다를 수 있기 때문에 `null` 체크만 잘 해주면 쉽게 풀 수 있는 문제입니다.

<br><br>

# Java Code 1

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            if (sum >= 10) {
                node.next = new ListNode(sum - 10);
                carry = 1;
            } else {
                node.next = new ListNode(sum);
                carry = 0;
            }
            
            node = node.next;
        }
        
        if (carry == 1) {
            node.next = new ListNode(1);
        }
        
        return result.next;
    }
}
```

<br><br>

# Solution 2

`Discuss` 를 보니 굳이 `carry` 를 쓰지 않고 sum 변수 하나만을 사용하며 `% /` 연산으로 풀이할 수도 있었습니다.

`%` 연산 비용이 부담되지 않는다면 훨씬 깔끔한 것 같습니다.

<br><br>

# Java Code 2

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int sum = 0;
        
        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            node.next = new ListNode(sum % 10);
            sum /= 10;
            
            node = node.next;
        }
        
        return result.next;
    }
}
```