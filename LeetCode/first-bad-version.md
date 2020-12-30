# Problem

- [문제 링크](https://leetcode.com/problems/first-bad-version/)

<br>

n 이 주어졌을 때 1 ~ n 까지 숫자들 중에서 첫번째로 나오는 __bad version__ 을 찾는 문제입니다.

`bool isBadVersion(version)` 함수는 `VersionControl` 클래스에 존재하고 `Solution` 클래스가 상속받고 있습니다.

<br><br>

# Solution

단순하게 `O(n)` 으로 제출하면 시간초과가 납니다.

이진탐색 (BinarySearch) 으로 풀어야 하는 문제입니다.

대신 중간값을 구할 때 한가지 주의해야 합니다.

단순히 `mid = (lo + hi) / 2` 로 짜면 `lo + hi` 값이 `int` 범위를 벗어납니다.

안전하게 `mid = lo + (hi - lo) / 2` 로 하면 통과하기 때문에 앞으로 이진탐색을 사용할 때는 이렇게 구하는 습관을 들이면 좋습니다.

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
