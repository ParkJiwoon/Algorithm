# Problem

- [문제 링크](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

<br>

문자열 `s` 에서 `p` 의 아나그램이 시작되는 모든 인덱스를 찾는 문제입니다.

<br><br>

# Solution

Slinding Window 를 사용하여 풀 수 있습니다.

Two Pointer 와 비슷한 개념인데 `s` 를 순서대로 순회하면서 `p` 길이 만큼의 `slow`, `fast` 인덱스를 유지합니다.

문자열을 비교할 때 매번 `substring` 을 찾을 필요 없이 앞의 문자는 빼고 뒤에 문자는 더해주는 방식으로 시간을 절약할 수 있습니다.

아나그램 여부는 `Arrays.equals` 를 사용하여 문자들의 갯수가 저장된 배열을 비교하면 됩니다.

`s` 문자열의 길이가 `n` 이라고 할 때 슬라이딩 윈도우에 `O(n)` 이 소요되고 `Arrays.equals` 는 내부적으로 `for` 문이 사용되기 때문에 `O(26)` 이 소요됩니다.

총 시간복잡도는 `O(n * 26)` 입니다.

<br><br>

# Java Code

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if (s.length() < p.length()) return res;
        
        int[] sCounts = new int[26];
        int[] pCounts = new int[26];
        
        for (int i = 0; i < p.length(); i++) {
            sCounts[s.charAt(i) - 'a']++;
            pCounts[p.charAt(i) - 'a']++;
        }
        
        int slow = 0, fast = p.length();
        
        while (true) {
            if (Arrays.equals(sCounts, pCounts)) {
                res.add(slow);
            }
            
            if (fast == s.length()) break;
            
            sCounts[s.charAt(slow++) - 'a']--;
            sCounts[s.charAt(fast++) - 'a']++;       
        }
        
        return res;
    }
}
```
