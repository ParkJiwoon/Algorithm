# Problem

- [문제 링크](https://leetcode.com/problems/merge-sorted-array/)

<br>

두 개의 배열 `nums1`, `nums2` 를 `nums1` 에 하나로 합치는 문제입니다.

두 배열은 이미 정렬되어있고 합쳐진 `nums1` 도 정렬되어야 합니다.

`nums1` 은 `nums2` 의 길이인 `n` 만큼의 추가 공간이 있으며 해당 공간은 0 으로 채워져 있습니다.

<br><br>

# Solution

단순하게 비교해서 넣으면 되는 문제입니다.

이렇게 추가 공간 없이 ***in place*** 로 구현해야 하는 문제는 새로 바뀐 값이 이후 로직에 영향을 주면 안됩니다.

따라서 배열의 뒤부터 비교해가며 넣어줍니다.

`i` 또는 `j` 가 0 이 되고 나면 나머지 하나가 0 이 될때까지 배열을 채워야 합니다.

`i` 는 이미 배열에 채워져 있기 때문에 `j` 가 0 이 될 때까지만 값을 넣어주면 됩니다

<br><br>

# Java Code

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[index--] = nums2[j--];
            } else {
                nums1[index--] = nums1[i--];
            }
        }
        
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }
}
```
