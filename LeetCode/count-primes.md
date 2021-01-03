# Problem

- [문제 링크](https://leetcode.com/problems/count-primes/)

<br>

주어지는 숫자보다 작은 모든 소수의 개수를 구하는 문제입니다.

<br><br>

# Solution

에라토스테네스의 체를 사용하여 소수를 미리 구해두면 `O(n)` 시간복잡도로 구할 수 있습니다.

2의 곱셉, 3의 곱셈, 4의 곱셉.. 전부 `isNotPrime` 으로 체크한 뒤에

`false` 인 숫자들만 카운팅하면 됩니다.

<br>

+) 2020. 01. 03

Discuss 보고 개선한 코드를 추가했습니다.

`count = n / 2` 로 시작하는 이유는 2 를 제외한 짝수는 소수가 될 수 없기 때문입니다.

2 의 배수는 어차피 셀 필요가 없기 때문에 처음부터 제외하고 3 부터 홀수들의 배수만 체크해서 소수가 아닌 값들을 제외합니다.

<br><br>

# Java Code

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        int count = 0;
        
        for (int i = 2; i * i < n; i++) {
            if (isNotPrime[i]) continue;
            
            for (int j = 2; i * j < n; j++) {
                isNotPrime[i * j] = true;
            }
        }
        
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}

// Discuss 참고 개선
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;

        boolean[] isNotPrime = new boolean[n];
        int count = n / 2;

        for (int i = 3; i * i < n; i += 2) {
            for (int j = i * i; j < n; j += i * 2) {
                if (isNotPrime[j]) continue;
                count--;
                isNotPrime[j] = true;
            }
        }

        return count;
    }
}
```
