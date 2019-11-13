# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    count = 0
    
    def pathSum(self, root: TreeNode, sum: int) -> int:
        if root is None:
            return 0
        
        if root.val == sum:
            self.count += 1
        
        if root.left is not None:
            self.goLeft(root.left, [root.val], sum)
            
        if root.right is not None:    
            self.goRight(root.right, [root.val], sum)
            
        return self.count
    
    def goLeft(self, left: TreeNode, vals: list, sum: int) -> int:
        if left is None:
            return
        
        if left.val == sum:
            self.count += 1
        
        for val in vals:
            if left.val + val == sum:
                self.count += 1
        
        length = len(vals)
        for i in range(0, length):
            vals[i] += left.val
            
        vals.append(left.val)
        self.goLeft(left.left, vals, sum)
        self.goRight(left.right, vals, sum)
        del vals[-1]
        
        length = len(vals)
        for i in range(0, length):
            vals[i] -= left.val
        
        
    def goRight(self, right: TreeNode, vals: list, sum: int) -> int:
        if right is None:
            return
        
        if right.val == sum:
            self.count += 1
        
        for val in vals:
            if right.val + val == sum:
                self.count += 1
        
        length = len(vals)
        for i in range(0, length):
            vals[i] += right.val
            
        vals.append(right.val)
        self.goLeft(right.left, vals, sum)
        self.goRight(right.right, vals, sum)
        del vals[-1]
        
        length = len(vals)
        for i in range(0, length):
            vals[i] -= right.val
    
