# Problem

- [문제 링크](https://leetcode.com/problems/climbing-stairs/)

<br>

난이도는 *__Easy__* 입니다.

계단을 1번 혹은 2번 올라갈 수 있을때 `n` 개의 계단에 올라가는 모든 경우의 수를 구하는 문제입니다.

<br><br>

# Solution

재귀를 활용하는 간단한 문제입니다.

`n` 번째 계단을 올라가는 경우의 수는 

1. `n-1` 에서 1칸 올라가는 경우
2. `n-2` 에서 2칸 올라가는 경우

이렇게 두가지입니다.

즉 *(n 번째 계단을 오르는 경우) = (n-1 번째 계단을 오르는 경우) + (n-2 번째 계단을 오르는 경우)* 로 정리할 수 있고

`climbStairs(n) = climbStairs(n-1) + climbStairs(n-2)` 라는 식이 나옵니다.

처음 제출할때는 이렇게 단순하게 생각해서 재귀로 짰더니 시간초과가 났습니다.

그래서 DP 로 고쳐서 제출하니 패스했습니다.

<br><br>

# Java Code

```java
class Solution {
    public int climbStairs(int n) {
        if (n < 4) return n;
        
        int[] dp = new int[n+1];
        
        dp[2] = 2;
        dp[3] = 3;
        
        for (int i=4; i<n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }


        return dp[n];
    }
}
```