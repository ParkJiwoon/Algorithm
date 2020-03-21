# Problem

- [문제 링크](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

<br>

난이도 *Easy* 문제입니다.

물건을 단 한번 사고 팔 수 있으며 물건의 가격은 매일매일 바뀝니다.

우리는 앞으로의 물건 가격을 미리 알 수 있고 남길 수 있는 가장 최대의 이익을 구하는 문제입니다.

<br><br>

# Solution

단순하게 생각해서 가장 쌀 때 사고 가장 비쌀 때 팔면 되는 문제입니다.

가장 싸고 비싼 때를 알기 위해서 `for` 문을 한번 돌 필요 없습니다.

추가적으로 물건을 사기 전에는 팔 수 없다는 조건도 있기 때문에

가격은 최소값만 저장해두고 있으면 됩니다.

그리고 현재 가격에서 최소 가격을 뺀 값이 우리가 취할 수 있는 이익이기 때문에

이 값들 중 최대값을 구해주면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
}
```