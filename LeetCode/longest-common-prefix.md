# Problem

- [문제 링크](https://leetcode.com/problems/longest-common-prefix/)

<br>

주어진 문자열들의 공통되면서 가장 긴 prefix 를 구하는 문제입니다.

<br><br>

# Solution

단순하게 이중 `for` 문으로 구하면 됩니다.

`strs` 배열의 첫 번째 문자열을 기준으로 하여 나머지 문자열들과 각 인덱스의 문자가 일치하는 지 확인합니다.

만약 전부 일치하여 `for` 문이 통과되면 해당 문자를 `StringBuilder` 에 추가합니다.

나머지 문자열들 중 하나라도 일치하지 않는다면 가장 긴 공통 prefix 에 해당하지 않기 때문에 바로 리턴하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            for (String str : strs) {
                if (str.length() <= i || c != str.charAt(i)) {
                    return sb.toString();
                }
            }
            
            sb.append(c);
        }
        
        
        return sb.toString();
    }
}
```
