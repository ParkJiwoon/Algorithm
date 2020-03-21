# Problem

- [문제 링크](https://leetcode.com/problems/sort-colors/)

난이도 *Medium* 문제입니다.

빨간색, 파란색, 하얀색이 각각 0, 1, 2 로 주어지고 이 숫자들을 정렬하는 문제입니다.

단, 라이브러리에서 제공하는 정렬 함수를 사용하면 안됩니다.

<br><br>

# Solution

문제에서는 `Counting Sort` 로 `O(2n)` 만에 풀 수 있다고 언급했습니다.

*0, 1, 2* 의 갯수를 센 다음에 *0, 0, 1, 1, ..* 이렇게 주르륵 나열하면 됩니다.

`O(n)` 시간복잡도와 `O(1)` 공간복잡도로 문제를 풀려면 문제에 제시된 조건을 파악해야합니다.

이 문제는 단 세가지 숫자 *0, 1, 2* 만으로 이루어져 있습니다.

포인터 세개를 이용하여 양 끝에 두개의 포인터를 두고 나머지 하나는 증가시키면서 0 과 2를 양끝으로 보내면 됩니다.

0 을 만나면 왼쪽으로, 2를 만나면 오른쪽으로 보내고 1은 신경쓰지 않습니다.

0과 2가 다 보내지고 나면 1은 자동으로 가운데에 남아있게 됩니다.

그리고 증가하던 `i` 포인터가 `right` 포인터와 만나면 더이상 `swap` 할 게 없기 때문에 종료합니다.

포인터의 위치를 신경쓰며 구현만 잘 해주면 풀 수 있습니다.

<br><br>

# Java Code

```java
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        for (int i=0; i<=right; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left++);
            }
            
            if (nums[i] == 2) {
                swap(nums, i--, right--);
            }
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
```