# Problem

- [문제 링크](https://leetcode.com/problems/binary-number-with-alternating-bits/)

<br>

*__Easy__* 난이도의 문제입니다.

주어진 숫자 `n` 을 이진수로 바꾸었을 때 0 과 1 이 연속으로 나오는 구간이 있는지 없는지 판단하는 문제입니다.

<br><br>

# Solution

`n` 을 이진수로 바꾸어 줍니다.

길이가 1 이라면 반복되는 구간이 없기 때문에 항상 `true` 입니다.

인덱스 0 에 해당하는 문자 `even` 을 구하고 이와 반대되는 문자 `odd` 를 구합니다.

이진수 `String` 을 순회하며 인덱스가 짝수일 때와 홀수일 때 각각 `even` 과 `odd` 와 일치하는 지 확인합니다.

시간복잡도는 `O(n)` 입니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        String bit = Integer.toString(n, 2);
        
        if (bit.length() == 1) {
            return true;
        }
        
        char even = bit.charAt(0);
        char odd = even == '0' ? '1' : '0';
        
        for (int i = 0; i < bit.length(); i++) {
            if (i % 2 == 0 && even != bit.charAt(i)) {
                return false;
            }
            
            if (i % 2 != 0 && odd != bit.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
```
