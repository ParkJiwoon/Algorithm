# Problem

- [문제 링크](https://leetcode.com/problems/split-array-largest-sum/)

<br>

자연수 배열 `nums` 와 숫자 `m` 이 주어집니다.

배열을 `m` 개의 부분 배열로 나눕니다.

각 부분 배열의 합 중에서 최대값을 구합니다.

`m` 개로 나눌 수 있는 모든 경우의 수에서 나오는 부분 배열의 최대값 중에서 가장 작은 값을 구하는 문제입니다.

<br>

예를 들어 부분 배열 A, B, C 로 나누는 경우와 D, E, F 로 나누는 경우가 있다고 가정합니다.

A, B, C 의 각 부분 합 중에서 최대 값은 sum(A) 입니다.

D, E, F 의 각 부분 합 중에서 최대 값은 sum(D) 입니다.

sum(A) 와 sum(D) 중에서 더 작은 값인 sum(D) 가 이 문제에서 구하는 답입니다.

```java
min(max(sum(A), sum(B), sum(C)) , max(sum(D), sum(E), sum(F)))
```

<br><br>

# Solution

Binary Search 로 구할 수 있습니다.

일반적인 이진탐색이랑 좀 다르게 여기서는 범위가 인덱스가 아닌 합(sum) 입니다.

해당 배열에서 나올 수 있는 가장 작은 합과 가장 큰 합을 구합니다.

`minSum` 은 배열의 원소가 하나인 경우이고, 가장 큰 원소 값이 `minSum` 이 됩니다.

`maxSum` 은 모든 배열을 더하면 됩니다.

<br>

`minSum` 과 `maxSum` 을 범위로 하여 이진 탐색을 시작합니다.

중간값 `mid` 를 기준으로 `canSplit` 함수를 호출합니다.

<br>

`canSplit` 함수에서는 부분배열의 합을 미리 정해두고 배열을 임의로 나누는 로직이 들어있습니다.

배열의 합을 더해가면서 기준값 `targetSum` 보다 값이 높아지면 부분 배열의 끝이라고 판단하고 `count` 를 더해줍니다.

<br>

`count` 가 `m` 보다 커진다면 지금 `targetSum` 값으로는 `m` 개보다 배열이 많이 쪼개진다는 뜻이므로 더 큰 값을 기준으로 삼아야 합니다.

```java
lo = mid + 1;
```

<br>

만약 `count` 가 `m` 보다 같거나 작다면 최소값을 구하기 위해 기준을 좀 더 낮춰서 다시 확인합니다.

```java
hi = mid - 1;
```

<br>

이렇게 이진 탐색을 전부 완료하고 남은 값이 배열을 `m` 개만큼 쪼갠 경우에 구할 수 있는 가장 작은 최대값입니다.

<br><br>

# Java Code

```java
class Solution {
    public int splitArray(int[] nums, int m) {
        int minSum = 0, maxSum = 0;
        
        for (int num : nums) {
            minSum = Math.max(minSum, num);
            maxSum += num;
        }
        
        int lo = minSum, hi = maxSum;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (canSplit(mid, nums, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    
    public boolean canSplit(int targetSum, int[] nums, int m) {
        int count = 1, sum = 0;
        
        for (int num : nums) {
            sum += num;
            
            if (sum > targetSum) {
                count++;
                sum = num;  // first element of next subarray
                
                if (count > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
```
