# Problem

- [문제 링크](https://leetcode.com/problems/maximum-subarray/)

<br>

주어진 배열에서 가장 큰 구간합을 구하는 문제입니다.

<br><br>

# Solution

DP 로 풀면 `O(n)` 에 구할 수 있습니다.

대신 별도의 배열을 따로 선언할 필요 없이 `nums` 배열에 덮어씁니다.

현재 값 `nums[i]` 와 지금까지의 지금까지의 합 `nums[i-1]` 을 더한 값과 그냥 현재값을 비교하여 어느 값이 더 큰지 확인합니다.

만약 `nums[i-1] + nums[i]` 값이 더 크다면 구간합이 유지된 상태로 계속 진행한다고 생각하면 됩니다.

만약 `nusm[i]` 값이 크다면 이전까지의 구간을 초기화 하고 새로운 구간을 시작합니다.

범위를 구하는 것이 아닌 원소의 합만 구하면 되기 때문에 `sum` 최대값을 저장합니다.

<br><br>

# Java Code

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            sum = Math.max(sum, nums[i]);
        }
        
        return sum;
    }
}
```
