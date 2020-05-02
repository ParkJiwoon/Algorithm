# Problem

- [문제 링크](https://leetcode.com/problems/duplicate-zeros/)

<br>

배열에 0 이 존재하면 0 인덱스부터 오른쪽 쉬프트 합니다.

모든 쉬프트를 하고난 뒤의 배열의 모습을 구하면 됩니다.

<br><br>

# Solution

투 포인터로 풀 수 있습니다.

0 의 갯수를 미리 카운트합니다.

추가 공간을 사용하지 않고 배열을 덮어써야 하기 때문에 마지막 인덱스부터 시작합니다.

`zeroCount` 는 쉬프트 횟수와 같기 때문에 `arr[i + zeroCount] = arr[i]` 로 값을 갱신해줍니다.

단 `i + zeroCount` 인덱스가 배열의 길이보다 작아야 합니다.

만약 `arr[i]` 가 0 이라면 그 즉시 `arr[i + zeroCount]` 에 0 을 넣고 인덱스를 하나 당겨줍니다.

시간복잡도는 `O(n)` 입니다.

<br><br>

# Java Code

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        
        for (int a : arr) {
            if (a == 0) zeroCount++;
        }
        
        int n = arr.length;
        
        for (int i = n-1; i >= 0; i--) {
            int j = i + zeroCount;
            
            if (arr[i] == 0) {
                if (j < n) arr[j] = 0;
                zeroCount--;
                j--;
            }
            
            if (j < n) arr[j] = arr[i];
        }
    }
}
```