# Problem

- [문제 링크](https://leetcode.com/problems/target-sum/)

<br>

`nums` 배열에 있는 각 숫자에 + 또는 - 중 하나를 선택해서 전부 계산할 경우 `S` 와 같은 값이 나오는 경우의 수는 몇 가지인지 찾는 문제입니다.

<br><br>

# Solution

DFS 를 이용해서 모든 경우의 수를 찾아주면 됩니다.

`index` 를 하나씩 증가시키면서 `nums[index]` 를 더하는 경우, 빼는 경우를 차례대로 확인합니다.

<br><br>

# Java Code

```java
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0, 0);
    }
    
    private int dfs(int[] nums, int S, int index, int sum) {
        if (index == nums.length) {
            return S == sum ? 1 : 0;
        }
        
        return dfs(nums, S, index + 1, sum + nums[index]) +
               dfs(nums, S, index + 1, sum - nums[index]);
    }
}

```
