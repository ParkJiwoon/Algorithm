# Problem

- [문제 링크](https://leetcode.com/problems/valid-parentheses/)

<br>

난이도는 *__Easy__* 이며 주어진 문자열의 괄호쌍이 옳게 되어있는지 판단하는 문제입니다.

<br><br>

# Solution

여는 괄호가 있으면 닫는 괄호가 반드시 존재해야 하고 `(` 괄호가 `}` 나 `]` 괄호와 매칭 될 수 없습니다.

백준에서 풀었던 [균형잡힌 세상](https://bcp0109.tistory.com/66) 문제와 완전히 일치하는 문제입니다.

스택을 이용하여 간단히 풀 수 있습니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                default:
                    stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
```