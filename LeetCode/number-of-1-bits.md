# Problem

- [문제 링크](https://leetcode.com/problems/number-of-1-bits/)

<br>

숫자 `n` 을 이진수로 변환했을 때 1 비트의 갯수를 구하는 문제입니다.

<br><br>

# Solution

시프트 연산을 진행하면서 풀면 됩니다.

주의할 점은 음수도 주어질 수 있기 때문에 `>>>` 연산을 사용해야 합니다.

<br><br>

# Java Code

```java
public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        
        while (n != 0) {
            sum += (n & 1);
            n >>>= 1;
        }
        
        return sum;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun hammingWeight(n:Int):Int = Integer.toBinaryString(n).count { it == '1' }
}
```
