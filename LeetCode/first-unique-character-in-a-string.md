# Problem

- [문제 링크](https://leetcode.com/problems/first-unique-character-in-a-string/)

<br>

주어진 String 에서 중복되지 않는 첫 번째 문자의 인덱스를 구하는 문제입니다.

<br><br>

# Solution

Note 를 보면 문자열은 소문자로만 이루어져 있기 때문에 26 개의 int 배열을 선언해서 모든 문자의 갯수를 담습니다.

다시 문자를 쭉 돌면서 갯수가 1 인 문자의 인덱스를 리턴하면 `O(n)` 에 풀 수 있습니다.

만약 소문자만 해당되지 않는다면 `HashMap` 을 쓰면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (letters[c - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun firstUniqChar(s: String): Int = s
        .groupingBy { it }
        .eachCount()
        .mapTo(mutableListOf()) { it }
        .firstOrNull { it.value == 1 }
        ?.let { s.indexOf(it.key) } ?: -1
}
```
