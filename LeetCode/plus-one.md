# Problem

- [문제 링크](https://leetcode.com/problems/plus-one/)

<br>

주어진 배열을 하나의 숫자로 생각하고 1 을 더한 결과 배열을 리턴하면 됩니다.

[1, 2, 3] 은 123 으로 생각하고 1 을 더한 [1, 2, 4] 배열을 리턴합니다.

[9, 9] 는 100 이 되기 때문에 [1, 0, 0] 을 리턴해야 하고 배열로 [0, 0] 이 주어지기도 합니다.

<br><br>

# Solution

배열의 마지막 원소부터 더해줍니다.

만약 1 을 더한 값이 10 미만이라면 추가적인 처리가 필요 없기 때문에 바로 `digits` 값을 리턴합니다.

만약 10 이 넘는다면 0 으로 변경해줍니다.

인덱스 0 까지 모두 순회 했는데도 메소드가 끝나지 않았다는건 자릿수 변화가 있다는 뜻입니다.

새로운 배열 `res` 를 선언하고 나머지 `res[0] = 1` 처리만 해주고 리턴합니다.

처음엔 `digits` 배열을 덮어쓰려고 했으나 전부 0 으로 바뀌어서 어차피 결과는 동일합니다.

<br><br>

# Java Code

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;        
        
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            
            if (digits[i] < 10) {
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] res = new int[n + 1];
        res[0] = 1;
        
        return res;
    }
}
```
