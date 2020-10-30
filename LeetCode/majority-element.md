# Problem

- [문제 링크](https://leetcode.com/problems/majority-element/)

<br>

배열이 주어졌을 때 가장 많이 나오는 숫자를 찾아 리턴하는 문제입니다.

가장 많이 나오는 빈도는 문제에 명시된 대로 `배열의 길이 / 2` 입니다.

<br><br>

# Solution

`Map` 을 사용하면 `O(n)` 에 풀 수 있습니다.

숫자를 세면서 Map 에 기록하다가 `count > nums.length / 2` 인 순간의 숫자를 리턴하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            
            if (count > nums.length / 2) {
                return num;
            }
        }
        
        return 0;
    }
}
```

<br>

# Koltin Code

```kotlin
class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map: Map<Int, Int> = mapOf()
        
        for (num in nums) {
            val count = map.getOrDefault(num, 0) + 1
            map.put(num, count)

            if (count > nums.size / 2) {
                return num
            }
        }
        
        return 0
    }
}
```
