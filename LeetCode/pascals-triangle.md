# Problem

- [문제 링크](https://leetcode.com/problems/pascals-triangle/)

<br>

자연수 `numRows` 가 주어지면 해당 수를 높이로 갖는 파스칼의 삼각형을 만들면 됩니다.

<br><br>

# Solution

주어진 대로 2중 `for` 문으로 구하면 됩니다.

파스칼 삼각형의 양 끝은 1 이기 때문에 처음과 시작에 1 을 넣고 나머지는 바로 윗 층의 List 를 꺼내서 구합니다.

<br><br>

# Java Code

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(1);
            
            if (i != 0) {
                row.add(1);
            }
            
            for (int j = 0; j < i - 1; j++) {
                List<Integer> before = res.get(i - 1);
                row.add(before.get(j) + before.get(j + 1));
            }
            
            row.add(1);
            res.add(row);
        }
        
        return res;
    }
}
```
