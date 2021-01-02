# Problem

- [문제 링크](https://leetcode.com/problems/binary-tree-level-order-traversal/)

<br>

이진 트리에서 같은 높이에 있는 노드들의 값을 묶는 문제입니다.

왼쪽에서 오른쪽 순서로 넣어야 합니다.

<br><br>

# Solution

단순하게 DFS 로 해결하면 됩니다.

값을 담을 `list` 를 선언하고 왼쪽부터 차례대로 들어갑니다.

`level` 변수로 높이를 계속 갖고 들어가며 `list.size()` 가 `level` 과 같다면 새롭게 만난 높이이기 때문에 리스트를 추가해줍니다.

<br><br>

# Java Code

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(res, root, 0);
        return res;
    }
    
    private void traverse(List<List<Integer>> list, TreeNode node, int level) {
        if (node == null) return;
        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        traverse(list, node.left, level + 1);
        traverse(list, node.right, level + 1);
    }
}
```
