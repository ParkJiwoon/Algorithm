# Problem

- [문제 링크](https://leetcode.com/problems/jump-game-ii/)

<br>

자연수 배열 `nums` 는 각 인덱스에서 이동할 수 있는 최대 거리를 의미합니다.

마지막 인덱스에 도달 가능한 최소 이동 횟수를 구하는 문제입니다.

<br><br>

# Solution

BFS 로 짰다가 시간초과가 나서 Discuss 참고했습니다.

Greedy 로 `O(n)` 에 답을 구할 수 있습니다.

간단히 변수 설명을 하자면 `count` 는 우리가 구하려는 답, 즉 이동한 횟수입니다.

`currMax` 는 현재 구간 (`count`) 에서 가장 멀리 점프 할 수 있는 인덱스입니다.

`nextMax` 는 가장 멀리 점프할 수 있는 인덱스입니다.

<br>

핵심은 `count` 를 구하는 방법인데 `i` 를 순차적으로 증가시키면서 `currMax` 와 만나면 `count` 를 증가시킵니다.

`count` 를 구간이라고 생각하면 됩니다.

현재 `i` 부터 `currMax` 구간에서 최대한 점프할 수 있는 거리를 구해서 `nextMax` 로 저장합니다.

`currMax` 에 도달할 때마다 점프 횟수를 한번 사용한 것이므로 `count` 를 하나 증가시키고 `currMax` 를 다음 이동가능한 구간인 `nextMax` 로 변경해줍니다.

문제에서 항상 마지막 인덱스에 도착할 수 있다는 조건이 있기 때문에 `nextMax` 는 항상 마지막 인덱스로 끝나게 됩니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/jump-game-ii-1.png?raw=true)

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/jump-game-ii-2.png?raw=true)

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/jump-game-ii-3.png?raw=true)

<br><br>

# Java Code

```java
class Solution {
    public int jump(int[] nums) {
        int count = 0, currMax = 0, nextMax = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            
            if (i == currMax) {
                count++;
                currMax = nextMax;
            }
        }
        
        return count;
    }
}
```
