# Problem
- 문제 링크 : https://leetcode.com/problems/count-primes/

주어지는 숫자보다 작은 모든 소수의 개수를 구하는 문제입니다.
<br>
<br>

# Solution
에라토스테네스의 체를 사용하여 `O(n)` 시간복잡도로 구할 수 있습니다.

2의 곱셉, 3의 곱셈, 4의 곱셉.. 전부 `isNotPrime` 으로 체크한 뒤에

`false` 인 숫자들만 카운팅하면 됩니다.
<br>
<br>

# Java Code
```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        
        for(int i=2; i*i<n; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            
            for (int j=2; i*j<n; j++) {
                isNotPrime[i*j] = true;
            }
        }
        
        int count = 0;
        for (int i=2; i<n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}
```