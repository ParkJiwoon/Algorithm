# Problem

- [문제 링크](https://leetcode.com/problems/squares-of-a-sorted-array/)

<br>

배열의 값을 제곱한 다음 오름차순으로 정렬하면 됩니다.

<br><br>

# Solution 1

배열의 값을 제곱한 뒤에 `Arrays.sort` 를 사용하여 정렬하면 됩니다.

시간복잡도는 `O(n * log n)` 입니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        
        Arrays.sort(A);
        
        return A;
    }
}
```

<br><br><br>

# Solution 2

*__Two Pointer__* 로 `O(n)` 에 풀 수 있습니다.

배열의 양쪽 끝에서부터 제곱값을 비교하며 큰 값을 `ret` 배열 뒤부터 넣어줍니다.

주어지는 배열이 이미 정렬된 상태라서 `O(n)` 에 가능하고 만약 정렬이 되어있지 않다면 정렬을 먼저 해주어야 합니다.

<br><br>

# Java Code 2

```java
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ret = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[left] * A[left] < A[right] * A[right]) {
                ret[i] = A[right] * A[right];
                right--;
            } else {
                ret[i] = A[left] * A[left];
                left++;
            }
        }
        
        return ret;
    }
}
```