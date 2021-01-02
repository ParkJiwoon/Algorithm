# Problem

- [문제 링크](https://leetcode.com/problems/group-anagrams/)

<br>

`String[] strs` 값이 주어지면 **Anagrams** 을 이루는 단어들을 한 리스트로 묶어서 출력하는 문제입니다.

**Anagrams** 이란 문자의 순서를 바꾸어서 만들 수 있는 다른 문자를 말하며

간단히 생각하면 같은 숫자의 문자들로 이루어진 `String` 들을 하나로 묶으면 됩니다.

주어지는 값은 모두 소문자이며 출력 순서는 상관 없다는 조건이 있습니다.

<br><br>

# Solution

Hash 로 문제를 해결할 수 있습니다.

주어진 문자열이 소문자 알파벳만으로 이루어졌다는 사실을 통해서 해시를 구현할 수 있습니다.

길이 26 의 `int` 배열을 선언한 뒤에 알파벳 숫자만큼 카운팅 합니다.

예를 들어 `bacc` 라는 문자열을 받았을 때 이걸 `keyArray` 로 변환한다면

`[1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]`

이런 문자열이 됩니다.

`accb` 도 변환한다면 위와 같은 문자열이 됩니다.

`Arrays.toString(int[] arr)` 을 통해 배열을 통째로 `String` 으로 변환할 수 있습니다.

내부적으로 `for` 문과 `StringBuilder` 를 사용하기 때문에 시간복잡도는 `O(N * K)` 가 됩니다.

<br>

두 번째 솔루션은 다른 사람들의 **Submission Code** 를 참고했습니다.

두번째 솔루션과 같은 해시지만 배열 `String` 을 그대로 키 값으로 사용했던 것과 달리 `Long` 값을 사용합니다.

26 개의 소수값을 배열에 미리 넣어둔 뒤 알파벳의 갯수만큼 `hashKey` 값에 곱해줍니다.

이와 같은 풀이가 가능한 이유는 소수의 곱이라 다른 **Anagrams** 값과 중복될 일이 전혀 없기 때문입니다.

시간복잡도는 동일하게 `O(N * K)` 지만 `Array to String` 과정이 없기 때문에 세번째 솔루션이 미세하게 더 빠릅니다.

<br><br>

# Java Code

```java
// 1. 배열 자체를 String 으로 만들어서 키값으로 사용
// k 값이 작아서 그런건지 키값 String 길이가 길어서 그런건지 소트보다 속도는 느림
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) count[c - 'a']++;
            String key = Arrays.toString(count);
            
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}


// 2. 소수값을 이용하여 hash key 값을 만듬
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 
                        23, 29, 31, 37, 41, 43, 47, 53, 
                        59, 61, 67, 71, 73, 79, 83, 89, 
                        97, 101};
        
        Map<Long, List<String>> map = new HashMap<>();

        for (String str : strs) {
            long hashKey = 1;
            for (char c : str.toCharArray()) {
                hashKey *= (long) primes[c - 'a'];
            }
            
            if (!map.containsKey(hashKey)) {
                map.put(hashKey, new LinkedList<>());
            }
            map.get(hashKey).add(str);
        }
        
        return new LinkedList<>(map.values());
    }
}
```
