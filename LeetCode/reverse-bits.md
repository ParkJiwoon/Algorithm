# Problem

- [문제 링크](https://leetcode.com/problems/reverse-bits/)

<br>

주어진 비트를 뒤집으면 됩니다.

<br><br>

# Solution

비트 전체를 순회하면서 1 과 AND 연산을 반복합니다.

`n` 의 가장 오른쪽에 있는 값이 `res` 의 가장 왼쪽에 가야 하므로 `res` 는 0 부터 왼쪽 쉬프트, `n` 은 오른쪽 쉬프트를 반복하며 계속 비교하면 됩니다.

<br><br>

# Java Code

```java
public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        
        return res;
    }
}

// 이건 꼼수
public class Solution {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
```
