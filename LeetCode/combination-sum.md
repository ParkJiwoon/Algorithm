# Problem

- [문제 링크](https://leetcode.com/problems/combination-sum/)

<br>

*__Medium__* 문제입니다. 

`candidates` 에 있는 원소들 중 합이 `target` 이 되는 리스트 묶음을 `return` 하면 됩니다.


<br><br>

# Solution

원소들은 중복해서 사용될 수 있지만 결과에는 중복되는 `list` 가 없어야 합니다.

처음에는 DP 로 생각했으나 우리가 구해야되는건 `List` 들의 목록입니다.

각 단계별로 저장되는 값은 `List` 이고 결국 메모이제이션을 통해서 다음 값을 구하려고 해도 저장된 `List` 만큼 전부 순회해야 합니다.

결국 백트래킹과 큰 차이가 없기 때문에 정해는 백트래킹이라고 생각합니다.

현재 `candidate` 값이 `target` 보다 작으면 `temp` 리스트에 넣은 뒤 다음 `target` 을 `target - candidate` 하여 계속 호출해줍니다.

만약 `target` 값이 0 이 된다면 `temp` 에 있는 값들의 합이 `target` 이라는 뜻이므로 `result` 리스트에 넣어주면서 쭉 돌면 됩니다.

`candidates[0]` 부터 시작하며 `candidates[1]` 부터 시작할 때는 이전값인 `candidates[0]` 값을 볼 필요가 없으므로 백트래킹 함수에 `index` 를 같이 넘깁니다.

<br><br>

# Java Code

```java
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0, len = candidates.length; i < len; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(candidates[i]);
            backtracking(candidates, i, 1, target - candidates[i], temp);
        }
        
        return result;
    }
    
    public void backtracking(int[] candidates, int index, int tempSize, int target, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList(temp));
            return;
        }
        
        for (int i = index, len = candidates.length; i < len; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                backtracking(candidates, i, tempSize + 1, target - candidates[i], temp);
                temp.remove(tempSize);
            }
        }
    }
}
```
