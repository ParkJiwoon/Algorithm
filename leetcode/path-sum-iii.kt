/**
 * 문제: https://leetcode.com/problems/path-sum-iii
 * 풀이: https://bcp0109.tistory.com/130
 */ 

// Using backtracking with List
// Time complexity: O(n^2)
class Solution {
    var count = 0
    
    fun pathSum(root: TreeNode?, sum: Int): Int {
        root ?: return 0
        if (root.`val` == sum) count++
        
        pathChild(root.left, mutableListOf(root.`val`), sum)
        pathChild(root.right, mutableListOf(root.`val`), sum)
        return count
    }
    
    fun pathChild(current: TreeNode?, vals: MutableList<Int>, sum: Int) {
        current ?: return
        
        val parentVals = vals.map { it + current.`val` }.toMutableList()
        parentVals.add(current.`val`)
        count += parentVals.count{ it == sum }
        
        pathChild(current.left, parentVals, sum)
        pathChild(current.right, parentVals, sum)
    }
}


// Using recursive
class Solution {
    fun pathSum(root: TreeNode?, sum: Int): Int {
        root ?: return 0
        
        return pathSequenceSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
    }
    
    fun pathSequenceSum(node: TreeNode?, sum: Int): Int {
        node ?: return 0
        
        var count = if (node.`val` == sum) 1 else 0
        count += pathSequenceSum(node.left, sum - node.`val`) + pathSequenceSum(node.right, sum - node.`val`)
        
        return count
    }
}


// Using hashmap
// Time complexity: O(n)
class Solution {
    fun pathSum(root: TreeNode?, sum: Int): Int {
        return recursive(root, 0, sum, hashMapOf(0 to 1))
    }
    
    fun recursive(node: TreeNode?, accumulateSum: Int, sum: Int, map: HashMap<Int, Int?>): Int {
        node ?: return 0
        
        val currSum = accumulateSum + node.`val`
        var count =  map[currSum - sum] ?: 0
        
        map[currSum] = map[currSum]?.plus(1) ?: 1
        count += recursive(node.left, currSum, sum, map)
        count += recursive(node.right, currSum, sum, map)
        map[currSum] = map[currSum]!! - 1
        
        return count
    }
}
