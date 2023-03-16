# Problem

- [문제 링크](https://leetcode.com/problems/single-element-in-a-sorted-array)

<br>

숫자만 존재하는 오름차순 배열이 주어집니다.

모든 값들은 2개씩 존재하고 단 하나의 값만 1개 존재합니다.

1개만 존재하는 값을 찾는 문제입니다.

<br><br>

# Solution

그냥 Map 을 사용해도 되는 문제지만 추가 조건으로 `O(log n) time and O(1) space` 의 복잡도를 요구합니다.

이 조건을 만족하기 위해선 이분탐색이 필요합니다.

하지만 이 문제는 일반적인 이분탐색과 다르게 찾아야 하는 값이 따로 주어지지 않습니다.

그럼 범위를 절반으로 나누었을 때 왼쪽과 오른쪽 중 찾으려는 값이 있는 곳을 알 수 있을까요?

힌트는 "모든 숫자는 반드시 두개씩 존재한다" 입니다.

반드시 두개씩 연달아 존재하기 때문에 인덱스 위치를 파악해서 숫자를 비교하면 단 하나만 있는 값의 위치를 알 수 있습니다.

대신 현재 index 가 홀수인지 짝수인지에 따라 비교해야 하는 대상이 바뀌기 때문에 그 부분만 체크해주면 됩니다.

<img width="962" alt="image" src="https://user-images.githubusercontent.com/28972341/225664925-fb1de28d-37a5-4bd6-9859-59bf93b38833.png">

<br><br>

# Java Code

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;

            if (mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                // mid 위치가 짝수면 오른쪽 값이랑 비교하고 같으면 single 은 오른쪽에 있음
                left = mid + 2;
            } else if (mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                // mid 위치가 홀수면 왼쪽 값이랑 확인하고 같으면 single 은 오른쪽에 있음
                left = mid + 1;
            } else {
                // 위에 전부 해당 안되면 single 은 왼쪽에 있음
                right = mid;
            }

        }

        return nums[left];
    }
}
```
