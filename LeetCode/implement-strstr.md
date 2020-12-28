# Problem

- [문제 링크](https://leetcode.com/problems/implement-strstr/)

<br>

문자열 두개가 주어졌을 때 `haystack` 안에 `needle` 문자열의 위치를 구하는 문제입니다.

Java 의 `indexOf` 함수를 직접 구현한다고 생각하면 됩니다.

<br><br>

# Solution

단순하게 비교하면 됩니다.

`substring` 을 쓰면 좀더 쉬우나, 문제의 취지가 이것도 허용하지 않는거라면 직접 `charAt` 으로 일일히 비교하거나 `substring` 처럼 문자열을 만들어서 비교하면 됩니다.

<br><br>

# Java Code

```java
// using substring
class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        
        for (int i = 0; i < haystack.length() - len + 1; i++) {
            String s = haystack.substring(i, i + len);

            if (s.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}

// normal
class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        
        for (int i = 0; i < haystack.length() - len + 1; i++) {
            boolean isEqual = true;
            
            for (int j = 0; j < len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isEqual = false;
                }
            }
            
            if (isEqual) {
                return i;
            }
        }
        
        return -1;
    }
}
```
