# Problem

- [문제 링크](https://leetcode.com/problems/path-sum-iii/)

<br>

*__Easy__* 문제입니다. (체감 난이도는 *__Medium__* 입니다)

이진 트리가 주어지고, `root` 부터 아래로 내려가면서 연속된 노드들의 합이 `sum` 이 되는 경우의 수를 구하는 문제입니다.

<br><br>

# Solution 1

반드시 연속되야만 하기 때문에 연속되지 않은 값은 갖고 있을 필요가 없습니다.

예를 들면 `root` 가 10 이고 `left` 자식인 5 를 탐색해야 합니다.

5는 현재 자신의 값과 `root` 와의 합인 `[5, 15]` 와 `sum` 을 비교해야 합니다.

이걸 `List` 를 넘기는 대신에 10 을 더하는 경우, 더하지 않는 경우 두가지로 나누어서 호출하면 됩니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        return pathSequenceSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathSequenceSum(TreeNode node, int sum) {
        if (node == null) return 0;
        
        int count = (sum == node.val) ? 1 : 0;
        count += pathSequenceSum(node.left, sum - node.val) + pathSequenceSum(node.right, sum - node.val);
        
        return count;   
    }
}
```

<br><br>

# Solution 2

**Discuss** 에서는 `HashMap` 을 사용하여 `O(n)` 에 푸는 풀이가 있었습니다.

처음에는 이해를 잘 못했지만 차근차근 로그를 찍어가면서 확인해보니 어느정도 알 것 같았습니다.

`HashMap` 에다가 지금까지 지나온 노드들의 누적 합을 저장해두고 있는지 확인하면 됩니다.

예제를 보고 설명해보겠습니다. 위 *Example* 중에서 `[10, 5, 3, 3]` 만 본다고 생각합시다.

가장 끝의 자식노드인 3 에서 확인해야될 값은 **_[현재 노드의 값, 부모 노드부터 누적합, 조부모 노드부터 누적합... root 노드부터 현재까지 누적합]_**

이렇게 트리의 높이에 비례하여 비교해야될 값이 늘어나서 첫 풀이에는 `List` 를 넘겼었습니다.

이번에는 루트노드부터의 누적합을 `HashMap` 에 저장해두면 됩니다.

`HashMap` 은 `{ "누적합" : "갯수" }` 형식으로 예제를 기준으로 `{10 : 1, 15: 1, 18: 1, 21: 1}` 이렇게 `[10, 15, 18, 21]` 이 한개씩 들어가있습니다.

그리고 누적합에서 `target` 넘버를 뺀 값이 `map` 에 존재한다면 현재 노드부터 루트 노드까지 연속된 노드들의 합 중에 일치하는 값이 있다는 뜻입니다.

마지막 노드인 3 에서 가능한 `sum` 의 경우는 `[21, 11, 6, 3]` 입니다.

현재 노드까지의 누적합 21 에서 `[21, 11, 6, 3]` 을 빼면 `[0, 10, 15, 18]` 입니다.

`HashMap` 에 들어있는 값과 똑같지 않나요?

마지막 노드까지 나올 수 있는 연속합들을 한번에 비교할 수 있습니다.

근데 `map` 에 0은 없는데 어디서 넣을까요?

`root` 부터 현재 노드까지 더한 경우가 `sum` 이 될 수도 있기 때문에 처음에 `{0: 1}` 을 넣고 시작합니다.

그림 없이 설명하려니 좀 힘들 수가 있는데 코드를 보면 더 이해하기 쉬울 수도 있습니다.

<br><br>

# Java Code 2

```java
class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return recursive(root, 0, sum, map);
    }
    
    public int recursive(TreeNode node, int accumulateSum, int sum, HashMap<Integer, Integer> map) {
        if (node == null) return 0;
        
        accumulateSum += node.val;
        int count = map.getOrDefault(accumulateSum - sum, 0);
        
        map.put(accumulateSum, map.getOrDefault(accumulateSum, 0) + 1);
        count += recursive(node.left, accumulateSum, sum, map) + recursive(node.right, accumulateSum, sum, map);
        map.put(accumulateSum, map.get(accumulateSum) - 1);
        
        return count;
    }
}
```