# Problem
- 문제 링크 : https://leetcode.com/problems/first-unique-character-in-a-string/

문자열 하나가 주어지면 가장 첫 번째로 나오는 `Unique` 문자의 `index` 를 찾는 문제입니다.
<br>
<br>

# Solution
문자열을 전부 확인하기 전까지는 문자의 갯수를 알 수 없습니다.

따라서 문자의 갯수를 전부 카운팅 후에 갯수가 1 인 문자의 `index` 를 찾으면 됩니다.

문제 조건에서 문자열은 전부 알파벳 소문자로만 이루어져 있다고 알려주었기 때문에 `int[] letters = new int[26]` 을 선언합니다.

각 문자의 갯수를 전부 배열에 담아 주고, 다시 순서대로 돌면서 count == 1 인 index 를 구합니다.

만약 아무것도 없다면 -1 을 리턴합니다.
<br>
<br>

# Java Code
```java
class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        
        for (char c : s.toCharArray()) {
            letters[c-'a']++;
        }
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (letters[c-'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
```