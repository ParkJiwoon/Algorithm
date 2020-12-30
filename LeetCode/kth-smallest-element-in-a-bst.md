# Problem

- [문제 링크](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

<br>

주어진 이진 탐색 트리에서 `k` 번째로 큰 수를 구하는 문제입니다.

<br><br>

# Solution

이진 탐색 트리기 때문에 중위 순회 (Inorder) 를 사용하면 답을 구할 수 있습니다.

순서대로 순회하면서 `k` 번째 값을 저장하면 됩니다.

Iterative 로 구하려면 `Stack` 을 사용하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    int rank = 1;
    int res = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    
    public void traverse(TreeNode node, int k) {
        if (node == null) return;
        
        traverse(node.left, k);
        if (rank++ == k) res = node.val;
        traverse(node.right, k);
    }
}
```
