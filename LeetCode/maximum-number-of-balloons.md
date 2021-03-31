# Problem

- [문제 링크](https://leetcode.com/problems/maximum-number-of-balloons/)

<br>

주어진 문자열을 섞어서 "balloon" 을 몇 개 만들 수 있는지 구하는 문제입니다.

<br><br>

# Solution

String 을 순회하면서 `balloon` 각 문자의 갯수를 카운트 하면 됩니다.

문자 한 세트가 있어야 한 단어가 만들어지므로 가능한 `balloon` 의 갯수는 `b`, `a`, `l`, `o`, `n` 의 갯수의 최소값입니다.

`l` 과 `o` 는 두 번씩 나와야 단어가 완성되므로 나누기 2 해줍니다.


<br><br>

# Java Code

```java
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        int min = Integer.MAX_VALUE;
        
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        count['l' - 'a'] /= 2;
        count['o' - 'a'] /= 2;
        
        for (char c : "balloon".toCharArray()) {
            min = Math.min(min, count[c - 'a']);
        }
        
        return min;
    }
}
```

<br>

사실 그냥 단순하게 풀어도 됩니다.

```java
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        
        for (char ch : text.toCharArray()) {
            if (ch == 'b') b++;
            else if (ch =='a') a++;
            else if (ch == 'l') l++;
            else if (ch == 'o') o++;
            else if (ch == 'n') n++;
        }
        
        return Math.min(Math.min(b, a), Math.min(Math.min(l / 2, o / 2), n));
    }
}
```
