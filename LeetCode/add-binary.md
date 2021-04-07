# Problem

- [문제 링크](https://leetcode.com/problems/add-binary/)

<br>

2진수 두개를 받아서 합한 결과를 리턴하는 문제입니다.

<br><br>

# Solution

처음에는 2진수 -> 10진수 변환 후 더하려고 했는데 2진수 길이가 너무 길어서 그런지 `NumberFormatException` 이 발생했습니다.

그래서 그냥 1 의 자리부터 더한 다음에 뒤집는 방식으로 구현했습니다.

Stack 자료구조를 써도 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        
        while (aIdx >= 0 || bIdx >= 0) {
            if (aIdx >= 0) sum += a.charAt(aIdx--) - '0';
            if (bIdx >= 0) sum += b.charAt(bIdx--) - '0';
            
            sb.append(sum % 2);
            sum /= 2;
        }
        
        if (sum == 1) sb.append(sum);
        return sb.reverse().toString();
    }
}
```
