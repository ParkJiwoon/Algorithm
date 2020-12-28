# Problem

- [문제 링크](https://leetcode.com/problems/power-of-three/)

<br>

주어지는 숫자 `n` 이 3 의 x 제곱수가 되는지 확인하는 문제입니다.

<br><br>

# Solution

단순하게 반복하면 됩니다.

3 의 배수인지 확인한 후에 3 으로 계속 나눕니다.

계속 나눈 값이 3 의 배수가 아닐 때의 값이 1 이면 3 의 제곱수고 아니면 다른 숫자가 섞여 있는 겁니다.

`n == 0` 인 케이스만 예외처리 해주면 간단하게 풀리는 문제입니다.

<br><br>

# Java Code

```java
// iterative
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        
        while (n % 3 == 0) {
            n /= 3;
        }
        
        return n == 1;
    }
}

// recursive
class Solution {
    public boolean isPowerOfThree(int n) {
        return n == 1 || n > 0 && n % 3 == 0 && isPowerOfThree(n / 3);
    }
}
```
