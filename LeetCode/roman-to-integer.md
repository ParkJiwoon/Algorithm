# Problem

- [문제 링크](https://leetcode.com/problems/roman-to-integer/)

<br>

로마 문자가 주어지면 숫자로 바꾸는 문제입니다.

<br><br>

# Solution

싫어요가 많을 만한 문제입니다.

별다른 풀이는 없고 그냥 문제에서 주어진 대로 구현하면 됩니다.

주의할 점은 `I`, `X`, `C` 는 바로 뒤에 나오는 문자가 지금 문자보다 크면 숫자를 더하지 말고 빼야 한다는 점입니다.

<br><br>

# Java Code

```java
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = getNumber(c);
            
            if (i + 1 == s.length()) {
                sum += num;
                continue;
            }
            
            char next = s.charAt(i + 1);
            
            // 바로 뒤에 나오는 숫자보다 작으면 숫자를 빼야함
            if (num < getNumber(next)) {
                sum -= num;
            } else {
                sum += num;
            }
        }
        
        return sum;
    }
    
    public int getNumber(char character) {
        switch(character) {
            case 'V': { return 5; }
            case 'X': { return 10; }
            case 'L': { return 50; }
            case 'C': { return 100; }
            case 'D': { return 500; }
            case 'M': { return 1000; }
            default: { return 1; }
        }
    }
}
```
