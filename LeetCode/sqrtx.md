# Problem

- [문제 링크](https://leetcode.com/problems/sqrtx/)

<br>

주어지는 숫자 `x` 의 제곱근을 구하는 문제입니다.

만약 8 의 제곱근처럼 정수로 나누어 떨어지지 않으면 소수점 자리를 전부 버립니다.

<br><br>

# Solution

`1 ~ x` 까지를 범위로 잡고 Binary Search 를 실시합니다.

중간값 `mid` 가 정답이 되는 조건은 `mid * mid <= x < (mid + 1) * (mid + 1)` 이 될 때입니다.

한가지 주의할 점은 `mid * mid` 가 너무 큰 수가 되어버리면 `int` 범위를 벗어나서 음수가 될 수 있습니다.

따라서 안전하게 양변을 나눈 값으로 비교합니다.

<br><br>

# Java Code

```java
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int lo = 1, hi = x;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid <= x / mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}
```
