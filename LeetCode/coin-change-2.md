# Problem

- [문제 링크](https://leetcode.com/problems/coin-change-2/)

<br>

동전의 리스트가 주어지면 합이 `amount` 가 되는 경우의 수를 구하는 문제입니다.

<br><br>

# Solution

dp 문제입니다.

`dp[i]` 는 **i 원까지 동전의 경우의 수** 입니다.

`dp[i] += dp[i - coin]` 식은 `j` 원이 되기 위해서 추가되는 동전의 수라고 생각하며 됩니다.

예를 들어 `j` 가 10 이고 동전 1, 2, 5 를 갖고 있을 때 경우의 수는

1. `dp[9]` + 1 원
2. `dp[8]` + 2 원
3. `dp[5]` + 5 원

이렇게 세가지 경우의 수가 됩니다.

`dp[9], d[8], dp[5]` 또한 각각 해당 인덱스까지의 모든 경우의 수 이기 때문에 전부 더해주면

`dp[10]` 의 총 경우의 수가 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}
```