# Problem

- [문제 링크](https://leetcode.com/problems/first-bad-version/)

<br>

n 이 주어졌을 때 1 ~ n 까지 숫자들 중에서 첫번째로 나오는 __bad version__ 을 찾는 문제입니다.

`bool isBadVersion(version)` 함수는 `VersionControl` 클래스에 존재하고 `Solution` 클래스가 상속받고 있습니다.

<br><br>

# Solution

단순하게 `O(n)` 으로 제출하면 시간초과가 납니다.

결국 이진탐색으로 풀어야 하는 문제입니다.

그런데 이진탐색을 할 때에도 주의해야 할 점이 있습니다.

저는 평소에 중간값인 `mid` 를 구할 때 `(lo + hi) / 2` 식으로 계산을 했는데 이럴 경우 `lo + hi` 값에서 오버플로우가 발생합니다.

`n` 이 _2126753390_ 인 상태에서 시작하고 답이 _2126753389_ 라면 첫 `mid` 값은 _2126753391 / 2_ 가 됩니다.

다음 `mid` 값을 계산할 때는 _2126753390 + 2126753391 / 2_ 로 _-1104837211_ 가 되기 때문에 반복문이 끝나지 않고 무한루프에 빠지게 됩니다.

오버플로우를 피하기 위해서는 `lo + (hi - lo) / 2` 식을 이용해야 합니다.

앞으로는 이진 탐색을 사용할 때 위 식으로 하는 습관을 들여야 할 것 같습니다.

<br><br>

# Java Code

```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}
```
