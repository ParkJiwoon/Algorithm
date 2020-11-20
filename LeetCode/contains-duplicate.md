# Problem

- [문제 링크](https://leetcode.com/problems/contains-duplicate/)

<br>

주어진 배열에서 중복되는 값이 있는지 찾는 문제입니다.

<br><br>

# Solution

`HashSet` 을 사용하여 `O(n)` 에 풀 수 있습니다.

`HashSet.add` 함수는 이미 중복된 값이 있는 경우 false 를 리턴합니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        
        return false;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean 
        = nums.toList().distinct().size != nums.size
}
```
