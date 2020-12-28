# Problem

- [문제 링크](https://leetcode.com/problems/valid-palindrome/)

<br>

주어진 문자열이 Palindrome 을 이루는지 확인하는 문제입니다.

대신 숫자, 알파벳 소문자/대문자 만 비교합니다.

<br><br>

# Solution

처음에는 정규식으로 필요없는 모든 문자를 제거한 후 중간지점부터 양쪽으로 인덱스를 이동시키며 비교하는 방법을 했습니다.

제출하니 속도가 너무 안나와서 정석대로 양 끝부터 차례대로 비교해가는 방식으로 변경했습니다.

숫자나 소문자/대문자 여부는 `Character.isLetterOrDigit` 메소드로 확인하였고 다른 문자인 경우 인덱스를 이동시킵니다.

<br><br>

# Java Code

```java
// 직접 비교
class Solution {
    public boolean isPalindrome(String s) {       
        int i = 0, j = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();
        
        while (i <= j) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(chars[j])) {
                j--;
            } else if(chars[i++] != chars[j--]) {
                return false;
            }
        }
        
        return true;
    }
}

// 정규식
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        
        // 정규식으로 다른 문자 제거
        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        
        // 중간값부터 비교
        int toLeft = s.length() / 2;
        int toRight = s.length() / 2;
        
        // 짝수면 toLeft 를 하나 빼줌
        if (s.length() % 2 == 0) {
            toLeft -= 1;
        }
        
        while (toLeft >= 0) {
            if (s.charAt(toLeft--) != s.charAt(toRight++)) {
                return false;
            }
        }
        
        return true;
    }
}
```
