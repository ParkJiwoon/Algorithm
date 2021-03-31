# Problem

- [문제 링크](https://leetcode.com/problems/non-decreasing-array/)

<br>

주어진 배열의 **원소 하나만** 바꿔서 Non-decreasing Array 를 만드는 문제입니다.

문제에서 정의하는 Non-decreasing Array 란 그냥 오름차순 배열을 의미합니다.

<br><br>

# Solution

생각보다 실수하기 쉬운 문제입니다.

우선 `for` 문을 돌면서 `increasing` 구간을 찾습니다.

하나도 없으면 `true` 를 리턴하고, 두 개 이상 나온다면 `false` 를 리턴합니다.

만약 `increasing` 구간이 한 개라면 `nums[i]` 와 `nums[i + 1]` 중 하나를 바꿔줘야 합니다.

- `nums[i]` 만 바꿨을 때의 반례 : `[5,7,1,8]`
- `nums[i + 1]` 만 바꿨을 때의 반례 : `[4,2,3]`

그래서 **`nums[i]` 를 바꾼 경우의 배열** 과 **`nums[i + 1]` 를 바꾼 경우의 배열** 두 가지를 각각 만들어서 체크해야 합니다.

<br>

하지만 배열을 두개나 만들어서 또 체크하는 건 시간적으로나 공간적으로 비효율적입니다.

우선 두 가지 사실을 생각해야 합니다.

1. `nums[i]` 값은 다음 차례에서는 확인하지 않는다. 
2. `nums[i]` 값은 `nums[i -1]` 보다 커야한다.

1 번을 예를 들면 `nums[0]` 과 `nums[1]` 을 비교하고 난 후에는 `nums[1]` 과 `nums[2]` 만 비교합니다.

`nums[0]` 은 바뀌든 말든 의미가 없기 때문에 굳이 바꿔줄 필요가 없습니다.

2 번은 `nums[i]` 값과 `nums[i + 1]` 값 중 어느 값을 바꿔야 할지 결정할 수 있게 해줍니다.

결국 두 값 중 하나를 바꿔줘야 하는데 이걸 비교하는 시점에서는 `nums[i] > nums[i + 1]` 조건이 보장된 상태입니다.

만약 `nums[i - 1] > nums[i + 1]` 인데 `nums[i] = nums[i + 1]` 처리를 해버리면 무조건 false 상태가 됩니다.

```java
nums = [10, 15, 5]

nums[i - 1] = 10
nums[i] = 15
nums[i + 1] = 5

// 설명
nums[i] 와 nums[i + 1] 중 하나를 무조건 바꿔줘야 하는데
nums[i] 를 5 로 바꿔버리면 nums[i - 1] 보다 작아진다.
```

<br><br>

# Java Code

```java
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (modified) return false;
                modified = true;
                
                // 다음에 비교할 nums[i + 1] 값만 바꿔주면 됨
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        
        return true;
    }
}
```
