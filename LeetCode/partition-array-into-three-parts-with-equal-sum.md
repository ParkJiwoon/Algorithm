# Problem

- [문제 링크](https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/)

<br>

주어진 배열을 3 등분 합니다.

나뉘어진 각 부분배열들의 모든 합이 똑같게 되도록 3등분 할 수 있는지 묻는 문제입니다.

<br><br>

# Solution

아이디어를 알면 쉽게 풀 수 있는데 모르면 굉장히 복잡해집니다.

가장 중요한 포인트는 다음 세개입니다.

1. non-empty 배열. 즉, 부분 배열에는 최소 하나의 원소가 존재
2. n 등분이 아니라 3 등분으로 숫자가 고정되어 있음
3. 모든 부분 배열의 합은 같음

<br>

위 조건들로 우리는 몇 가지 사실을 알 수 있습니다.

1. 주어진 배열의 합이 정확히 3 으로 나누어 떨어져야 함
2. 부분 배열의 합은 `sum / 3` 으로 고정되어 있음

<br>

부분 배열의 합을 미리 알고 있기 때문에 좀더 수월하게 답을 구할 수 있습니다.

각 부분 배열의 누적합 `partition` 이 목표값인 `goal` 에 도달하면 갯수를 하나씩 증가시킵니다.

`count` 가 3 이 되는 순간 조건이 성립합니다.

혹시 남은 원소가 있더라도 부분 배열의 합이 무조건 `goal` 이기 때문에 남은 원소의 합은 0 이 될 겁니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int a : arr) { sum += a; }
        
        // 3등분 했을 때 모두 같아야 하기 때문에 한 파트의 합은 무조건 sum/3 이다.
        int goal = sum / 3; 
        
        if (sum % 3 != 0) return false;
        
        int partition = 0, count = 0;
        for (int a : arr) {
            partition += a;
            
            if (partition == goal) {
                partition = 0;
                count++;
            }
            
            if (count == 3) {
                return true;
            }
        }
        
        return false;
    }
}
```
