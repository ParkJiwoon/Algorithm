# Problem

- [문제 링크](https://leetcode.com/problems/search-a-2d-matrix-ii/)

<br>

2차원 배열 `matrix` 안에 `target` 값이 있으면 `true` 

없으면 `false` 를 return 하는 문제입니다.

`matrix` 안의 숫자는 왼쪽에서 오른쪽으로 증가하고 위쪽에서 아래쪽으로 증가합니다.

<br><br>

# Solution

왼쪽에서 오른쪽으로, 위에서 아래로 증가한다는 사실을 이용하면 `O(n + m)` 에 풀 수 있습니다.

__오른쪽 위__ 혹은 __왼쪽 아래__ 에서 시작하며 현재 값보다 `target` 이 크면 커지는 방향으로 이동하고 작으면 작아지는 방향으로 이동하면 됩니다.

예를 들어 왼쪽 아래에서 시작한다면 `row = matrix.length - 1` 이고 `col = 0` 에서 시작합니다.

만약 찾는 값이 현재 위치에 있는 값보다 작으면 작은쪽 (위쪽) 으로 이동합니다. (`row--`)

현재 위치에 있는 값보다 크면 커지는 쪽 (오른쪽) 으로 이동합니다. (`col++`)

<br><br>

# Java Code

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        
        int row = matrix.length - 1;
        int col = 0;
        
        while (row >= 0 && col < matrix[0].length) {
            int value = matrix[row][col];

            if (target == value) {
                return true;
            } else if (target < value) {
                row--;
            } else {
                col++;
            }
        }
        
        return false;
    }
}

```
