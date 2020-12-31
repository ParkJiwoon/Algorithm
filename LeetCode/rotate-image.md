# Problem

- [문제 링크](https://leetcode.com/problems/rotate-image/)

<br>

`n * n` 행렬을 90 도 회전하느 문제입니다.

새로운 배열을 사용하지 말고 in-place 로 풀어야 합니다.

<br><br>

# Solution

위 아래 배열을 먼저 뒤집고 대각선 숫자들을 뒤집으면 됩니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/rotate-image.png?raw=true)

<br><br>

# Java Code

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // reverse up and down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
                
            }
        }
        
        // reverse diagonally
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
```
