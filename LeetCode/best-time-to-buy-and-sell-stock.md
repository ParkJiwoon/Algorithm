# Problem

- [문제 링크](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

<br>

`Stock` 의 가격이 배열로 주어지고 한번만 사고 한번만 팔 수 있을 때 구할 수 있는 가장 큰 이익을 구하는 문제입니다.

<br><br>

# Solution

한번만 사고 팔 수 있으므로 가장 싼 값에 사서 가장 비쌀 때 팔면 됩니다.

그런데 단순하게 `maxPrice` 값을 구하면 스톡을 사기 전 가격이 젤 비싼 경우가 발생합니다.

예제 1번만 봐도 배열의 최대값은 7, 최소값은 1 인데 스톡을 사기도 전에 판다는게 말이 안됩니다.

따라서 구해야될 최대값은 `오늘 가격 - 최소 가격` 의 최대값입니다.

`minPrice` 에서는 가장 작은 가격을 구하고 `maxProfit` 에는 해당 날의 가격에서 최소 가격을 뺀 이익의 최대값을 구합니다.

`O(n)` 의 시간복잡도가 소요되며, 끝나고 남은 `maxProfit` 이 답입니다.

<br><br>

# Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
}
```
