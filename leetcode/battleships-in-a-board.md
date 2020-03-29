# Problem

- [문제 링크](https://leetcode.com/problems/battleships-in-a-board/)

<br>

보드판이 주어졌을 때 배틀쉽의 갯수를 구하는 문제입니다.

배틀쉽은 X 로 이루어져 있고 빈 공간은 . 으로 이루어져 있습니다.

배틀쉽은 가로와 세로의 길이 중 하나가 무조건 1 이어야 합니다.

배틀쉽은 서로 딱 붙어있는 경우는 없고 무조건 한 칸 이상 거리를 두어야 합니다.

이 문제는 Example 과 다르게 십자가 모양은 테스트케이스로 주어지지 않습니다.

<br><br>

# Solution 1

이 문제의 핵심은 십자가 모양이 주어지지 않는다는 점입니다.

그렇다면 invalid 한 케이스는 없기 때문에 단순하게 배틀쉽 개수만 카운팅 해주면 됩니다.

원래라면 방문체크를 하면서 확인을 했겠찌만 `O(1) extra memory` 만 사용하라는 조건이 있기 때문에 다른 방법을 생각해야 합니다.

배틀쉽의 첫 X 를 기준으로 카운팅 해줍니다.

만약 `board[i][j]` 가 X 라고 할 때, `board[i-1][j]` 나 `board[i][j-1]` 이 X 라면 이전에 카운팅 했던 배틀쉽이라고 확신할 수 있습니다.

위 조건을 만족하지 않는 경우에만 `count++` 해주면 정답을 구할 수 있습니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i-1][j] == 'X') continue;
                    if (j > 0 && board[i][j-1] == 'X') continue;
                    count++;
                }
            }
        }
        
        return count;
    }
}
```

<br><br><br>

# Solution 2

만약 십자가 모양도 테스트 케이스로 주어진다고 한다면 모든 케이스를 생각해야합니다.

다음 Follow up 과 같은 제약이 없다면 BFS 를 이용하여 풀 수 있습니다.

<br>

> Follow up: <br>
> Could you do it in **one-pass**, using only **O(1) extra memory** and **without modifying the value** of the board?

<br>

보드판 전체를 돌면서 값이 X 인 좌표를 만나면 BFS 를 돌면서 모든 X 를 . 으로 바꿔줍니다.

BFS 를 순회할 때 `x, y` 좌표가 둘 다 시작점과 다르다면 모양이 십자가 모양이기 때문에 유효하지 않은 배틀쉽입니다.


<br><br>

# Java Code 2

```java
class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int count = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'X') {
                    count += bfs(i, j, board);
                }
            }
        }
        
        return count;
    }
    
    public int bfs(int x, int y, char[][] board) {
        boolean isBattleShip = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<Dot> q = new LinkedList<>();
        board[x][y] = '.';
        q.add(new Dot(x, y));
        
        while (!q.isEmpty()) {
            Dot dot = q.poll();
            
            if (dot.x != x && dot.y != y) {
                isBattleShip = false;
            }
            
            for (int i=0; i<4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                
                if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length) {
                    if (board[nx][ny] == 'X') {
                        board[nx][ny] = '.';
                        q.add(new Dot(nx, ny));
                    }
                }
            }
        }
        
        return isBattleShip ? 1 : 0;
    }
    
    private class Dot {
        int x, y;
        
        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
```