# Problem

- [문제 링크](https://leetcode.com/problems/simplified-fractions/)

<br>

*__Medium__* 난이도의 문제입니다.

`n` 이하의 수들이 분모가 되고 각 수가 1 이하가 되도록 하는 수들의 리스트를 구하는 문제입니다.

<br><br>

# Solution

단순하게 2중 for문으로 구하면 됩니다.

중복 확인은 `Set` 을 사용합니다.

<br><br>

# Java Code

```java
class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        Set<Float> set = new HashSet<>();
        
        for (float i = 2; i <= n; i++) {
            for (float j = 1; j < i; j++) {
                float div = j/i;
                
                if (!set.contains(div)) {
                    int child = (int) j;
                    int parent = (int) i;
                    
                    result.add(child + "/" + parent);
                    set.add(div);
                }
            }
        }
        
        return result;
    }
}
```
