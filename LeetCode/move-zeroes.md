# Problem

- [문제 링크](https://leetcode.com/problems/move-zeroes/)

<br>

주어진 배열에서 0 인 값을 전부 오른쪽 끝으로 보내면 됩니다.

나머지 값은 정렬하는 것이 아니라 원래 있던 순서 그대로 둡니다.

또다른 배열을 만들지 않고 주어진 배열 안에서만 해결해야 합니다. **_in-place_**

연산을 최소화 해야 합니다.

<br><br>

# Solution

***two-pointer*** 로 간단하게 문제를 풀 수 있습니다.

## 1. One Loop

값을 갱신할 `slow` 인덱스와 전체 배열을 훑을 `fast` 인덱스를 사용합니다.

`nums[fast]` 에 값이 있는 경우에만 `nums[slow]` 에 넣어 주면 되는데 주의할 점은 두 인덱스가 같지 않아야 합니다.

즉, `fast` 인덱스가 말그대로 `slow` 인덱스보다 큰 상황에서만 갱신해야 합니다. 안그러면 `nums[slow]` 에는 0 만 들어갑니다.

## 2. Two Loop

`index` 변수 하나를 선언하고 0 부터 시작합니다.

일반적인 `for` 문을 돌면서 `num` 값이 0 이 아닐 때만 `nums[index]` 에 넣어줍니다.

지나간 값은 다시 확인할 필요가 없기 때문에 `nums` 배열 자체에 갱신해주어도 문제가 없습니다.

`for` 문이 끝났을 때의 `index` 부터 배열 끝까지 남은 값을 0 으로 채워주면 됩니다.


<br><br>

# Java Code

```java
// 1. one loop
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                if (fast != slow) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                }
                
                slow++;
            }
        }
    }
}

// 2. two loop
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
```
