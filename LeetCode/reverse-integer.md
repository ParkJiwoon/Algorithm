# Problem

- [문제 링크](https://leetcode.com/problems/reverse-integer/)

<br>

주어진 숫자를 뒤집으면 됩니다.

<br><br>

# Solution

평범하게 1 의 자릿수부터 더해가면 됩니다.

한 가지 주의할 점은 `res` 값이 `int` 의 범위를 벗어날 수 있기 때문에 `long` 타입으로 선언 후에 나중에 바꿔주어야 합니다.

<br><br>

# Java Code

```java
class Solution {
    public int reverse(int x) {
        long res = 0;
        
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        
        if (-Integer.MAX_VALUE <= res && res <= Integer.MAX_VALUE) {
            return (int) res;
        } else {
            return 0;
        }
    }
}
```
