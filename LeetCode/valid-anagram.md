# Problem

- 문제 링크

<br>

주어지는 두 개의 String 이 anagram 을 이루는지 확인하는 문제입니다.

<br><br>

# Solution

동일한 문자를 갖고 있는지 확인해야 하기 때문에 `O(n)` 을 벗어날 수는 없습니다.

조건 중에 알파벳 소문자만 주어진다는 조건을 활용하여 배열을 선언한 뒤 거기에 각 알파벳의 갯수를 담아둡니다.

`s` 문자열은 + 하고 `t` 문자열은 - 합니다.

만약 배열의 값이 모두 0 이라면 해당 문자열은 anagram 을 이룬다고 할 수 있습니다.

만약 주어지는 문자열의 범위가 넓어진다면 `HashMap` 을 사용하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] stores = new int[26];
        
        for (char c : s.toCharArray()) {
            stores[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            stores[c - 'a']--;
        }
        
        for (int e : stores) {
            if (e != 0) return false;
        }
        
        return true;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
  fun isAnagram(s: String, t: String) 
    = s.groupingBy { it }.eachCount() == t.groupingBy { it }.eachCount()
}
```
