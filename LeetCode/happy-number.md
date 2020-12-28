# Problem

- [문제 링크](https://leetcode.com/problems/happy-number/)

<br>

주어진 `n` 이 Happy Number 에 해당하는 지 찾는 문제입니다.

Happy Number 여부를 판단하기 위해서는 다음과 같은 과정을 거쳐야 합니다.

1. `n` 을 각 자릿수별로 나눈다.
2. 나눈 수를 각각 제곱한 다음에 더한다.
3. 더한 수가 1이 되면 Happy Number

<br>

위 세 과정을 계속해서 반복하며 Happy Number 로 판단되는 경우 `true` 를 리턴하고 영원히 반복되는 Cycle 을 형성하는 경우 `false` 를 리턴합니다.

<br><br>

# Solution

반복문을 사용해서 풀 수 있습니다.

간단한 풀이는 `n` 을 계속 계산하면서 `HashSet` 에 담아서 확인하는 겁니다.

만약 추가 메모리 없이 풀고 싶다면 투포인터를 사용하면 됩니다.

Cycle 을 이룰 경우 `slow` 와 `fast` 의 변수가 언젠가 같아지는 순간이 옵니다.

<br><br>

# Java Code

```java
class Solution {
    // Space Complexity O(n) using HashSet
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n != 1) {
            if (!set.add(n)) {
                return false;
            }
            
            n = getNext(n);
        }
        
        return true;
    }
    
    // Space Complexity O(1)
    public boolean isHappy(int n) {
        int slow = getNext(n);
        int fast = getNext(getNext(n));
        
        while (slow != 1 && fast != 1) {
            if (slow == fast) {
                return false;
            }
            
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        return true;
    }

    private int getNext(int num) {
        int sum = 0;
        
        while (num != 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        
        return sum;
    }
}
```
