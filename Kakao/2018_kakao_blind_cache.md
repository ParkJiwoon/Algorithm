# Problem
- 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/17681

주어지는 두개의 지도를 겹친 결과를 출력하는 문제입니다.
<br>
<br>

# Solution
그림만 봐도 알수 있듯이 겹치는 부분은 # 겹치지 않은 부분은 빈칸으로 나옵니다.

친절하게 비트로 풀라고 안내까지 해주고 있으니 `Integer.toBinaryString` 함수를 사용하여 계산을 해줍니다.

1 과 0 으로 이루어진 `String`을 `replaceAll`로 전부 바꿔주면 됩니다.

한 가지 주의할 점이 하나 있습니다.

`1111(2)` 처럼 자릿수가 작은 글자는 `n`이 `5`일때 `01111`로 바꿔주어야 합니다.

여기서는 자리수를 맞춰주는 `String.format` 함수를 사용하여 `n` 자리만큼 공백으로 채워줍니다.
<br>
<br>

# Java Code
```java
class Solution {
    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i=0; i<n; i++) {          
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);  
            temp = String.format("%" + n + "s", temp);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }

        return answer;
    }
}
```