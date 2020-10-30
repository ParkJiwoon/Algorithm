# Problem

- [문제 링크](https://leetcode.com/problems/excel-sheet-column-number/)

<br>

Excel 의 행이 문자열로 주어지면 몇 번째 행인지 계산하는 문제입니다.

<br><br>

# Solution

문자열 뒤에서부터 계산해도 되는데 저는 앞에서부터 했습니다.

`ABZ` 라는 문자열을 받았다고 가정합니다.

수식으로 변경하면 다음과 같습니다.

```html
(A * 26 * 26) + (B * 26) + Z
```

*26 을 밖으로 빼서 정리해서 다시 수식을 표현할 수 있습니다.

```html
(((A * 26) + B) * 26) + Z
```

위 수식을 바탕으로 for 문을 돌립니다.

1. 시작 값은 0 이다.
2. 26 을 곱한다.
3. 문자를 더한다.

<br><br>

# Java Code

```java
class Solution {
    public int titleToNumber(String s) {
        int ret = 0;
        
        for (char c : s.toCharArray()) {
            ret *= 26;
            ret += c - 64;
        }
        
        return ret;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun titleToNumber(s: String): Int {
        return s.toCharArray().fold(0) { total, num -> total * 26 + num.toInt() - 64 }
    }
}
```
