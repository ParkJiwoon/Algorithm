# Problem

- [문제 링크](https://leetcode.com/problems/reverse-string/)

<br>

배열 `s` 가 주어지면 배열 안의 원소 순서를 거꾸로 뒤집는 문제입니다.

단, `O(1)` 의 추가 메모리만 사용해야 합니다.

<br><br>

# Solution

간단하게 `for` 문을 절반만 진행하면서 대칭되는 원소를 바꿔주면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun reverseString(s: CharArray): Unit {
        var i = 0
        var j = s.lastIndex
        
        while (i < j) {
            s[i] = s[j].also { s[j] = s[i] }
            i++
            j--
        }
    }
}
```
