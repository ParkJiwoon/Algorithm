# Problem

- [문제 링크](https://leetcode.com/problems/word-pattern/)

<br>

`pattern` 과 `str` 이 주어질 때 두 문자열의 패턴이 일치해야 합니다.

예시로 `abba` 가 주어지면 `str` 은 아래의 규칙을 가지면 됩니다.

1. 네 개의 단어로 이루어진다
2. 맨 앞과 맨 끝의 단어가 똑같다 (a)
3. 가운데의 두 단어가 똑같다 (b)


<br><br>

# Solution

`String[] words = str.split(" ")` 코드로 문자들을 나누고 시작합니다.

`pattern` 의 길이와 `words` 배열의 길이는 같아야 합니다.

각 패턴 `c` 와 각 문자열 `word` 를 키값으로 하는 `HashMap` 을 각각 선언하여 담아둡니다.

만약 `c` 키값이 존재하는데 `map` 에 있는 `map.get(c)` 와 현재 위치의 `word` 가 일치하지 않는다면 패턴 불일치입니다.

`pattern = "abba", str = "dog dog dog dog"` 으로 주어지는 케이스가 있기 때문에 `word` 를 키값으로 한 `HashMap` 에서도 한번 더 검사해줍니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();
        String[] words = str.split(" ");
        
        if (pattern.length() != words.length) return false;
        
        for (int i=0; i<words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (charMap.containsKey(c) && !charMap.get(c).equals(word)) {
                return false;
            }
            
            if (strMap.containsKey(word) && strMap.get(word) != c) {
                return false;
            }
            
            charMap.put(c, word);
            strMap.put(word, c);
        }
        
        return true;
    }
}
```