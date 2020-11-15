# Problem

- [문제 링크](https://leetcode.com/problems/generate-parentheses/)

<br>

`n` 개의 균형 잡힌 괄호를 이루는 문자열의 모든 케이스를 구하는 문제입니다.

<br><br>

# Solution

재귀를 사용하면 됩니다.

여는 괄호 `(` 를 붙이는 경우와 닫는 괄호 `)` 를 붙이는 경우에 따라서 재귀로 들어갑니다.

`open` 변수는 열 수 있는 괄호의 갯수, `close` 변수는 닫을 수 있는 괄호의 갯수입니다.

균형 잡힌 괄호를 만들어야 하기 때문에 `close` 변수는 `open` 변수보다 클 때만 붙일 수 있습니다.

만약 닫는 괄호가 더 많이 사용된 상태라면 이미 균형 잡힌 괄호가 아닙니다.

`open` 변수와 `close` 변수를 전부 사용해서 0 이 되버리면 문자열 `s` 를 결과 리스트에 담습니다.

<br><br>

# Java Code

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursive(res, "(", n - 1, n);
        return res;
    }
    
    public void recursive(List<String> res, String s, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(s);
            return;
        }
        
        if (open > 0) {
            recursive(res, s + "(", open - 1, close);
        }
        
        if (close > open) {
            recursive(res, s + ")", open, close - 1);
        }
    }
}
```
