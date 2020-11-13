# Problem

- [문제 링크](https://leetcode.com/problems/fizz-buzz/)

<br>

1 부터 주어진 `n` 까지의 숫자들을 순회하며 `List<String>` 을 만들면 됩니다.

3 의 배수에는 "Fizz", 5 의 배수에는 "Buzz" , 3 과 5 의 배수에는 "FizzBuzz" 넣고 나머지에는 숫자를 채워 넣으면 됩니다.

<br><br>

# Solution

단순하게 풀면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        
        for (int i = 1; i < n + 1; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));   
            }
        }
            
        return list;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun fizzBuzz(n: Int): List<String> {
        return (1..n).map { it ->
            when {
                it % 15 == 0 -> "FizzBuzz"
                it % 3 == 0 -> "Fizz"
                it % 5 == 0 -> "Buzz"
                else -> it.toString()
            }
        }
    }
}
```
