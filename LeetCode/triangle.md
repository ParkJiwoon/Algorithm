# Problem

- [문제 링크](https://leetcode.com/problems/triangle)

<br>

삼각형의 꼭대기부터 가장 아래로 가는 최단 거리를 구하는 문제입니다.

위에서 아래로 내려갈 때 이동할 수 있는 곳은 인접한 대각선 밖에 없습니다.

<br><br>

# Solution

현재까지 이동한 거리를 누적해서 더해나가다가 마지막에 최소값을 구하면 됩니다.

사실 이 문제는 위에서 아래로 내려가는 것보다 아래에서 위로 올라가는 Bottom Up 방식이 더 쉽게 구현할 수 있습니다.

우선 누적합을 저장해두는 `accSum` 배열을 선언합니다.

그리고 아래층부터 `step` 을 따라 올라가며 이동할 수 있는 거리를 구합니다.

양쪽 모두에서 이동할 수 있으므로 두 숫자 중 최솟값과 현재 `step` 값을 더하는 방식으로 쭉쭉 올라가면 됩니다.

<img width="857" alt="image" src="https://user-images.githubusercontent.com/28972341/223782219-bdd3703e-6cdd-4ac1-a7b8-24cdcead0222.png">


<br><br>

# Java Code

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // init 0
        int[] accSum = new int[triangle.size() + 1];

        // bottom up
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> step = triangle.get(i);

            for (int j = 0; j < step.size(); j++) {
                int min = Math.min(accSum[j], accSum[j + 1]);
                accSum[j] = min + step.get(j);
            }
        }

        return accSum[0];
    }
}
```
