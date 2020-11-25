# Problem

- [문제 링크](https://leetcode.com/problems/reshape-the-matrix/)

<br>

2차원 배열 `nums` 가 주어진다.

이 행렬의 값을 `r * c` 의 새로운 행렬로 바꾸는 문제입니다.

<br><br>

# Solution

`nums` 배열에 있는 값을 전부 `Queue` 에 담은 후에 `r * c` 배열에 맞춰서 다시 값을 채워넣으면 됩니다.

나누기와 나머지 연산자를 이용하면 Queue 를 사용하지 않고 문제를 해결할 수 있습니다.

시간 복잡도는 `O(r * c)` 입니다.

<br><br>

# Java Code

```java
// use Queue
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        Queue<Integer> q = new LinkedList<>();
        
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                q.add(nums[i][j]);
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = q.poll();
            }
        }
        
        return res;
    }
}

// without Extra Memory
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int a = nums.length, b = nums[0].length;

        if (r * c != a * b) {
            return nums;
        }
        
        int[][] res = new int[r][c];
        
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / b][i % b];
        }
        
        return res;
    }
}
```
