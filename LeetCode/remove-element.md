# Problem

- [문제 링크](https://leetcode.com/problems/remove-element/)

<br>

주어진 `nums` 에서 `val` 원소를 지우는 문제입니다.

`nums` 배열 값을 직접 변화시키면 되며, 리턴값은 배열의 길이입니다.

<br><br>

# Solution

단순하게 `val` 값이 아닐때에만 값을 넣어주고 인덱스를 증가시켜주면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        
        return index;
    }
}
```
