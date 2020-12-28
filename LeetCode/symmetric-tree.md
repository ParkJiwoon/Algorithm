# Problem

- [문제 링크](https://leetcode.com/problems/symmetric-tree/)

<br>
    
주어진 트리가 정확히 대칭을 이루는지 확인하는 문제입니다.

<br><br>

# Solution

그냥 비교하면 되는 문제입니다.

`null` 체크만 확실히 합니다.

<br><br>

# Java Code

```java
// 1. Recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isEqual(root.left, root.right);
    }
    
    public boolean isEqual(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        if (a.val != b.val) return false;
        
        return isEqual(a.left, b.right) && isEqual(a.right, b.left);
    }
}

// 2. Iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            
            q.add(a.left);
            q.add(b.right);
            q.add(a.right);
            q.add(b.left);
        }
        
        return true;
    }
}
```
