# Problem

- [문제 링크](https://leetcode.com/problems/binary-tree-inorder-traversal/)

<br>

트리가 주어졌을 때 `inorder` 순회한 결과를 리턴하는 문제입니다.

<br><br>

# Solution

많이 알려진 재귀로 풀면 `O(n)` 에 풀리겠지만 Follow up 에 다음 문장이 있었습니다.

```html
Recursive solution is trivial, could you do it iteratively?
```

iterative 하게 푸는 방법은 `Stack` 을 이용해서 다음 4 개 플로우를 반복하면 됩니다.

1. 현재 노드의 왼쪽 자식 노드를 전부 `Stack` 에 담는다.
2. `Stack` 에서 하나 pop 해서 `res` 에 담는다. (재귀로 깊게 들어갔다가 빠져 나오면서 넣는 것과 비슷)
3. 현재 노드에서 오른쪽 자식 노드로 이동한다.
4. 현재 노드가 `null` 이 아니라면 1~3 의 과정을 반복한다.

그림을 통해 표현하면 다음과 같습니다.

녹색으로 칠해진 노드는 현재 노드인 `node` 를 나타낸다고 생각하시면 됩니다.

<br>

## 1. Root 에서 시작, 왼쪽 자식 노드를 전부 Stack 에 담는다.

[3, 2, 1] 순서로 담기게 되어 `pop` 할 때는 depth 가 깊은 순인 [1, 2, 3] 순서로 나옵니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/binary-tree-inorder-traversal-1.png?raw=true)

<br>

## 2. Stack 에서 Pop 하면서 val 을 담는다. (1)

이때 오른쪽 노드의 상태를 확인합니다.

코드상으로는 `node = node.right` 로 매번 이동하지만, `null` 값이기 때문에 무시됩니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/binary-tree-inorder-traversal-2.png?raw=true)

<br>

## 3. Stack 에서 Pop 하면서 val 을 담는다. (2)

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/binary-tree-inorder-traversal-3.png?raw=true)

<br>

## 4. Stack 에서 Pop 하면서 val 을 담는다. (3)

오른쪽 자식 노드가 `null` 이 아니기 때문에 이동합니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/binary-tree-inorder-traversal-4.png?raw=true)

<br>

## 5. 1 번에서 했던 것처럼 현재 노드를 기준으로 왼쪽 자식 노드를 전부 Stack 에 담는다.

이후 과정은 현재 노드에서 1, 2, 3, 4 를 다시 반복하며 `inorder` 순회가 완성됩니다.

최종적으로는 노드의 숫자 순서대로 전부 출력됩니다.

![](https://github.com/ParkJiwoon/Algorithm/blob/master/LeetCode/image/binary-tree-inorder-traversal-5.png?raw=true)

<br><br>

# Java Code

```java
// 1. recursive
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(res, root);
        return res;
    }
    
    public void traverse(List<Integer> res, TreeNode node) {
        if (node == null) return;
        
        traverse(res, node.left);
        res.add(node.val);
        traverse(res, node.right);
    }
}

// 2. iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        
        return res;
    }
}
```

<br>

# Kotlin Code

```kotlin
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> = root?.let {
        inorderTraversal(root.left) + root.`val` + inorderTraversal(root.right)
    } ?: listOf()
}
```
