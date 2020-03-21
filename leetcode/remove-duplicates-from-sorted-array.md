# Problem
- [문제 링크](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

<br>

주어진 정렬된 배열에서 중복을 제거하여 배열(길이) 를 리턴하는 문제입니다.

<br><br>

# Solution

처음 `index` 값을 1로 저장해놓습니다.

반복문을 돌면서 `nums[i]` 와 `nums[i+1]` 이 달라진다면 중복된 값이 끝났다는 뜻이기 때문에 `nums[index] = nums[i+1]` 로 새 값을 넣어줍니다.

반복문이 끝난 후 `nums` 배열의 `index` 길이만큼 중복이 제거된 상태가 됩니다.

이 문제는 특이하게 `int` 형을 `return` 하는데 `nums` 에서 `return` 한 길이까지가 제출하는 정답이 되는 것 같습니다.

<br><br>

# Java Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[index] = nums[i+1];
                index++;
            }
        }
        
        return index;
    }
}
```
