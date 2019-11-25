/**
 * 문제: https://leetcode.com/problems/path-sum-iii
 * 풀이: https://bcp0109.tistory.com/130
 */ 
 
 
 // Using Recursive
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


// Using HashMap
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
