# Problem

- [문제 링크](https://leetcode.com/problems/climbing-stairs/)

<br>

계단을 한번에 한개 또는 두개씩 오를 수 있을 때 `n` 개의 계단을 오르는 모든 경우의 수를 구하는 문제입니다.

<br><br>

# Solution

피보나치랑 비슷하게 풀면 됩니다.

재귀로 하면 시간초과가 나기 때문에 DP 로 하거나 정 재귀로 하고싶다면 메모이제이션을 사용하면 됩니다.

<br><br>

# Java Code

```java
// using dp solution
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}

// without extra memory
class Solution {
    public int climbStairs(int n) {
        int a = 0, b = 1;
        int res = a + b;
        
        for (int i = 0; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        
        return res;
    }
}
```
