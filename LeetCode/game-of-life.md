# Problem

- [문제 링크](https://leetcode.com/problems/game-of-life/)

<br>

`n * m` 크기의 보드가 주어지고 각 칸에 존재하는 세포가 다음 세대가 되었을 때의 상태를 구하는 문제입니다.

<br><br>

# Solution

각 세포는 상하좌우와 대각선까지 해서 총 8 명의 이웃이 있습니다.

문제에 나와있는 세포들의 생존, 사망 조건을 정리하면 다음과 같습니다.

```html
# 살아있는 세포
  - 이웃이 2 명 미만이면 사망
  - 이웃이 3 명 초과면 사망
  - 이웃이 2, 3 명이면 현재 상태 그대로 진행
# 죽은 세포
  - 이웃이 3 명이면 생존
  - 그 외에는 현재 상태 그대로
```

<br>

단순하게 이중 for 문을 돌면서 8 방향 확인하면 됩니다.

주의해야 할 점은 변경된 세포의 상태를 바로 갱신해버리면 옆에 있는 세포의 조건을 검사할 때 꼬일 수 있다는 점입니다.

임시로 2차원 배열을 선언해서 해결할 수도 있지만 Follow up 에서 in-place 로 해결해보라고 나와있습니다.

`board` 의 값을 바로바로 갱신하되, 0 과 1 대신에 3 과 2 로 갱신해줍니다.

```html
현재 죽음 - 다음 세대에 살아남 ⇒ 3
현재 생존 - 다음 세대에 죽음 ⇒ 2
```

<br>

이렇게 변경해주면 숫자만 보고 현재 상태와 다음 세대를 알 수 있습니다.

모든 검사가 끝나면 `%2` 연산으로 상태를 갱신해주면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public void gameOfLife(int[][] board) {
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        int n = board.length, m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lives = 0;
                
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    if (board[x][y] == 1 || board[x][y] == 2) lives++;
                }
                
                if (board[i][j] == 0 && lives == 3) board[i][j] = 3;
                if (board[i][j] == 1 && (lives < 2 || lives > 3)) board[i][j] = 2;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
```
