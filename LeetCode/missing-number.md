# Problem

- [문제 링크](https://leetcode.com/problems/missing-number/)

<br>

`nums` 배열의 길이가 `n` 이라고 할 때 `0 ~ n` 까지의 숫자 중 배열에 없는 숫자를 구하는 문제입니다.

<br><br>

# Solution

`0 ~ n` 의 합에서 배열 원소의 합을 빼면 빠진 숫자가 나옵니다.

<br><br>

# Java Code

```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        
        return sum;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun missingNumber(nums: IntArray): Int = nums.foldIndexed(nums.size) { acc, i, num -> acc + i - num }
}
```
