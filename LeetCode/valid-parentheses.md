# Problem

- [문제 링크](https://leetcode.com/problems/valid-parentheses/)

<br>
    
주어진 문자열의 괄호쌍이 옳게 되어있는지 판단하는 문제입니다.

<br><br>

# Solution

여는 괄호가 있으면 닫는 괄호가 반드시 존재해야 하고 `(` 괄호가 `}` 나 `]` 괄호와 매칭 될 수 없습니다.

스택을 이용하여 여는 괄호가 나오면 그대로 `Stack` 에 넣어주고, 닫는 괄호가 나오면 `Stack.peek()` 값과 비교하여 쌍이 제대로 맞는지 확인하면 됩니다.

단순하게 `switch` 문이나 `if - else` 문으로 짤수도 있지만 `HashMap` 을 사용하면 반복되는 로직을 어느정도 줄일 수 있습니다.

`key = 닫는 괄호, value = 여는 괄호`로 저장해두고 닫는 괄호가 주어졌을 때 `stack` 의 가장 최근 값이 여는 괄호와 일치하는 지 바로 비교할 수 있습니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != map.get(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
```
