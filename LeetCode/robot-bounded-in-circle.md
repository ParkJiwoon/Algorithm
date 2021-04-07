# Problem

- [문제 링크](https://leetcode.com/problems/robot-bounded-in-circle/)

<br>

로봇이 존재합니다.

로봇은 3 개의 명령어만 듣습니다.

- G: 앞으로 한칸 이동
- L: 왼쪽으로 90 도 회전
- R: 오른쪽으로 90 도 회전

<br>

로봇이 수행해야하는 일련의 명령어 리스트인 `instructions` 이 주어졌을 때, 이 로봇이 영원히 같은 위치를 순회하는 지 판단하는 문제입니다.

<br><br>

# Solution

로봇을 움직이는건 굉장히 단순합니다.

(0, 0) 좌표에서 시작하여 처음 방향은 0 으로 설정합니다.

모든 행동을 완료한 후에 로봇의 상태만 확인하면 됩니다.

1. 행동을 완료했을 때 (0, 0) 위치에 있다면 몇번을 해도 같은 자리를 반복한다.
2. 행동을 완료했을 때 (0, 0) 위치는 아니지만 다른 방향을 보고 있다.

<br>

1 번은 너무 당연한 겁니다.

2 번은 example 3 에도 나와 있습니다.

다른 위치에 도달했을 때, 다른 방향을 보고 있다면 두번째 `instructions` 은 그 위치와 방향에서 새로 시작합니다.

그렇기 때문에 최대 4 번을 반복하면 원래 위치로 돌아옵니다.

반복문을 4 번 돌리면서 (0, 0) 위치에 돌아왔는지 확인해도 되지만, 위와 같은 방식으로 쉽게 확인할 수 있습니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, dir = 0;
        
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                x += dx[dir];
                y += dy[dir];
            } else if (instruction == 'L') {
                dir = (dir + 1) % 4;
            } else {
                dir = (dir + 3) % 4;
            }
        }
        
        // 1. 싸이클 완료후에 (0, 0) 에 있는지
        // 2. 또는 위치가 바꼈더라도 초기 방향과 다른 방향을 보고 있다면 
        //    4번 순회했을 시 원래 자리로 돌아옴
        return x == 0 && y == 0 || dir != 0;
    }
}
```
