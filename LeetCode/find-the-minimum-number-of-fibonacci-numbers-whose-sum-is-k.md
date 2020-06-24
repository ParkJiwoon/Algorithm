# Problem

- [문제 링크](https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/)

<br>

*__Medium__* 난이도의 문제입니다.

`k` 를 만들 수 있는 피보나치의 합들을 찾고 그 중에서 갯수가 가장 작은 값을 구하는 문제입니다.

<br><br>

# Solution

**Greedy**로 문제를 풀 수 있습니다.

`k` 보다 작은 피보나치 수열을 전부 `TreeSet` 에 담고 **k 보다 작으면서 가장 큰 피보나치 수** 를 계속해서 빼면 됩니다.

따로 증명은 안해봤지만 피보나치 수 중에 1, 1, 2, 3 이 있기 때문에 

가장 큰 수부터 계속 빼면 어떻게든 0 으로 나누어 떨어질 것으로 생각되었습니다.

`TreeSet.floor(n)` 은 `Set` 에 `n` 이 존재하면 `n` 을 리턴, 아니라면 `n` 보다 작으면서 가장 가까운 수를 리턴합니다.

<br><br>

# Java Code

```java
class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k < 2) {
            return 1;
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int lo = 0, hi = 1; hi < k;) {
            int sum = lo + hi;
            set.add(sum);
            lo = hi;
            hi = sum;
        }
        
        int count = 0;
        
        while (k > 0) {
            int num = set.floor(k);
            k -= num;
            count++;
        }
        
        return count;
    }
}
```
