# Problem

- [문제 링크](https://leetcode.com/problems/find-bottom-left-tree-value/)

<br>

*__Easy__* 문제입니다.

트리가 주어졌을 때 가장 아래쪽에 있고 가장 왼쪽에 있는 노드의 값을 구하는 문제입니다.

<br><br>

# Solution

단순하게 풀면 됩니다.

최고 깊이 `maxDepth` 와 리턴할 결과값 `result` 를 인스턴스 변수로 선언합니다.

**Preorder** 로 트리를 순회하면 `depth` 가 1 높아졌을 때 마주하는 노드가 가장 왼쪽에 있는 노드입니다.

`depth` 가 1 높아지는 순간의 노드값을 저장해두면서 트리를 모두 순회하면 됩니다.

시간복잡도는 `O(n)` (`n` 은 노드의 갯수) 입니다.

<br><br>

# Java Code

```java
class Solution {
    int maxDepth = 0;
    int result = 0;
        
    public int findBottomLeftValue(TreeNode root) {
        goChild(root, 1);
        return result;
    }
    
    public void goChild(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        
        if (depth > maxDepth) {
            result = node.val;
            maxDepth = depth;
        }
        
        goChild(node.left, depth + 1);
        goChild(node.right, depth + 1);
    }
}
```
