# Problem

- [문제 링크](https://leetcode.com/problems/two-sum/)

<br>

`nums` 배열 안의 숫자 중 합이 `target` 이 되는 인덱스 두개를 배열로 리턴하면 됩니다.

<br><br>

# Solution

`for` 문을 두번 돌면서 일일이 전부 비교하면 `O(n^2)` 에 답을 구할 수 있습니다.

`Map` 자료구조를 사용하여 `O(n)` 에 푸는 것입니다.

`Map` 에는 지나온 `target - nums[i]` 와 `index` 를 저장합니다.

만약에 `map.containsKey` 가 존재한다면 현재의 `nums[i]` 와 더해서 `target` 이 되는 값이 존재한다는 뜻입니다.

`Map` 에 있는 값이 무조건 이전 `index` 이므로 먼저 출력합니다. 

<br><br>

# Java Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            
            map.put(target - nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
}
```

# Kotlin Code

```kotlin
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for ((i, value) in nums.withIndex()) {
            map[target - value]?.let { return intArrayOf(it, i) }
            map[value] = i
        }

        return intArrayOf()
    }
}
```
