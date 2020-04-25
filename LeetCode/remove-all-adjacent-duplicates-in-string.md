# Problem

- [문제 링크](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

<br>

난이도 *__Easy__* 문제입니다.

문자열이 주어졌을 때 이웃해있는 두 문자가 같은 문자면 제거해야합니다.

만약 제거한 후의 문자열에서 같은 케이스가 발견되면 계속 삭제합니다.

최종적으로 이웃하면서 중복된 문자가 없을때까지 반복해줍니다.

<br><br>

# Solution 1

문자열 S 의 길이는 최대 20,000 이기 때문에 `O(n)` 시간복잡도로 푸는게 좋습니다.

일반적으로 풀면 S 한번 쭉 보면서 중복 제거, 다시 또 한번 보면서 중복 제거.. 이러면 `O(n^2)` 입니다.

시간을 줄이는 핵심적인 방법은 문자 두개를 제거했을 때

그 자리에 바로 이웃한 중복된 문자가 생기는지 확인하면 됩니다.

`removed` 배열을 하나 선언하여 문자열이 삭제되었는지 아닌지 체크합니다.

`for` 문을 돌면서 `before` 인덱스를 하나 선언한 뒤, 이웃한 두 문자를 삭제

이후 `before--; i++;` 로 그 다음으로 이웃한 두 문자를 계속 삭제하면 됩니다.

<br><br>

# Java Code 1

```java
class Solution {
    public String removeDuplicates(String S) {
        boolean[] removed = new boolean[S.length()];
        
        for (int i = 1; i < S.length(); i++) {
            int before = i-1;
                        
            while (!removed[before] && !removed[i] && S.charAt(before) == S.charAt(i)) {
                removed[before] = true;
                removed[i] = true;
                
                while (before > 0 && removed[before]) {
                    before--;
                }
                
                while (i < S.length()-1 && removed[i]) {
                    i++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            if (!removed[i]) {
                sb.append(S.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
```

<br><br><br>

# Solution 2

`Stack` 으로 간단하게 푸는 방법도 있습니다.

`for` 문 돌면서 `stack.peek()` 값과 같으면 바로 이전에 있던 문자와 같은 문자이기 때문에 `pop()` 해줍니다.

만약에 같지않으면 그냥 `push()` 만 하면 됩니다.

<br><Br>

# Java Code 2

```java
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
                
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : stack) {
            sb.append(c);    
        }
        
        return sb.toString();
    }
}
```