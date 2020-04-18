# Problem

- [문제 링크](https://leetcode.com/problems/diagonal-traverse/)

<br>

2차원 배열이 주어지면 주어진 조건에 따라서 배열을 리턴하면 됩니다.

<br><br>

# Solution

특별한 알고리즘 없이 조건을 찾아서 배열을 리턴해주면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        
        res[0] = matrix[0][0];
        res[res.length-1] = matrix[m-1][n-1];
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[x][y];
            
            if ((x + y) % 2 == 0) {
                if      (y == n-1)  { x++; }
                else if (x == 0)    { y++; }
                else                { x--; y++; }
            } else {
                if      (x == m-1)  { y++; } 
                else if (y == 0)    { x++; } 
                else                { x++; y--; }
            }
        }
        
        return res;
    }
}
```