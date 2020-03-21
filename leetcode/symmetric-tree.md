# Problem

- [문제 링크](https://leetcode.com/problems/symmetric-tree/)

<br>

난이도는 *__Easy__* 입니다.

이진 트리가 주어졌을 때 `root` 노드를 기준으로 양 쪽이 완전이 데칼코마니가 되는지 판단하는 문제입니다.

<br><br>

# Solution

`root` 부터 시작하며 두 노드를 비교해가면 됩니다.

두 노드는 항상 같은 높이어야 하고 정확히 대칭이 되는 위치여야 합니다.

따라서 두 노드를 비교 후에 다음 `compareNode` 를 호출할 때에는 

`left` 노드의 `left`, `right` 노드의 `right` 끼리 비교

`left` 노드의 `right`, `right` 노드의 `left` 끼리 비교

해야 합니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return compareNode(root.left, root.right);
    }
    
    public boolean compareNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left.val != right.val) return false;
        
        return compareNode(left.left, right.right) && compareNode(left.right, right.left);
    }
}
```