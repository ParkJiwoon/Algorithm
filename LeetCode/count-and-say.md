# Problem

- [문제 링크](https://leetcode.com/problems/count-and-say/)

<br>

문자열을 그룹으로 나누어서 `{갯수}{숫자}{갯수}{숫자}` 형식의 문자열로 다시 만들면 됩니다.

<br><br>

# Solution

1 만 고정된 문자열을 리턴하기 때문에 무조건 1 까지 갔다 와야 합니다.

재귀를 이용해서 `n-1` 의 문자열 값을 구하고 다시 계산해서 리턴합니다.

같은 숫자여도 구간이 다르면 카운트를 따로 해야 하기 때문에 `HashMap` 에 담으면 안되고 직접 비교하면서 세야 합니다.

<br><br>

# Java Code

```java
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        StringBuilder sb = new StringBuilder();
        String s = countAndSay(n - 1);
        char value = s.charAt(0);
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (value == c) {
                count++;
                continue;
            }
            
            sb.append(Integer.toString(count)).append(value);
            value = c;
            count = 1;
        }
        
        sb.append(Integer.toString(count)).sb.append(value);
        
        return sb.toString();
    }
}
```
