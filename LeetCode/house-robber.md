# Problem

- [문제 링크](https://leetcode.com/problems/house-robber/)

<br>

나는 강도고 배열은 내가 털 집의 돈을 순서대로 나타냅니다.

인접한 두 집을 동시에 털면 경찰에 알림이 가기 때문에 피해야 합니다.

하루에 훔칠 수 있는 가장 많은 돈을 구하는 문제입니다.

<br><br>

# Solution

DP 로 해결할 수 있습니다.

`dp` 배열을 선언했다고 가정할 때 `dp[i]` 는 `i` 번까지의 집까지 도달했을 때 훔친 돈의 `Max` 값 이라고 생각하면 됩니다.

그럼 `i` 번째 집에서 도둑이 얻을 수 있는 `Max` 의 경우의 수는 다음 둘 중 하나입니다.

1. `i - 2` 번째 집까지 털었던 Max 값 + `i` 번째 집의 돈
2. `i - 1` 번째 집까지 털었던 Max 값

<br>

이렇게 마지막 집까지 쭉 확인하고 남은 마지막 인덱스 값이 `Max` 값이 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        
        return nums[nums.length - 1];
    }
}
```
