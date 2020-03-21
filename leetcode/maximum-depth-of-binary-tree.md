# Problem

- [문제 링크](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

<br>

난이도는 *__Easy__* 입니다.

이진 트리가 주어지면 가장 큰 `depth`, 즉 트리의 `height` 를 구하는 문제입니다.

<br><br>

# Solution

재귀로 간단하게 구할 수 있습니다.

`root` 에서 0 으로 시작하여 `depth` 를 계속 끌고 내려가면서 `max` 값을 구하면 됩니다.

`node` 가 `null` 이 되는 `leaf node` 에서는 `depth` 를 반환하기 때문에 가장 큰 `depth` 값을 구할 수 있습니다.

<br><br>

# Java Code

```java
class Solution {
    public int maxDepth(TreeNode root) {
        return goDepth(root, 0);
    }
    
    public int goDepth(TreeNode node, int depth) {
        if (node == null) return depth;
        
        return Math.max(goDepth(node.left, depth + 1), goDepth(node.right, depth + 1));
    }
}
```