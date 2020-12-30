# Problem

- [문제 링크](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

<br>

`nums` 배열에서 `target` 숫자의 범위를 구하는 문제입니다.

`nums` 배열은 오름차순으로 정렬되어 있으며 중복된 값도 존재합니다.

<br>

# Solution

Lower Bound 와 Upper Bound 를 이용해서 답을 구하면 됩니다.

`target` 이상인 값을 찾으며 중복값이 있을 경우 가장 첫번째 인덱스를 구하는 Lower Bound.

`target` 초과인 값을 찾으며 중복값이 있을 경우 가장 첫번째 인덱스를 구하는 Upper Bound.

두 개를 이용하여 각각 `start`, `end` 인덱스를 구할 수 있습니다.

`start` 는 전체 범위를 대상으로 이진탐색을 하고 `end` 는 시작점인 `start` 부터 끝까지의 범위를 대상으로 탐색을 하면 됩니다.

시간복잡도는 `O(log n)` 입니다.

<br><br>

# Java Code

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findStartIndex(nums, target, 0, nums.length - 1);
        int end = findLastIndex(nums, target, start, nums.length - 1) - 1;
        
        if (start >= nums.length || start > end) {
            return new int[] {-1, -1};
        }
        
        return new int[] {start, end};
    }
    
    // lowerBound
    public int findStartIndex(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target <= nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }
    
    // upperBound
    public int findLastIndex(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return lo;
    }
}
```
