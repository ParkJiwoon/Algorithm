/**
 * first my code
 * https://leetcode.com/problems/path-sum-iii/submissions/
 */
class Solution {
    var count = 0
    
    fun pathSum(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        if (root.`val` == sum) count++
        
        pathChild(root.left, mutableListOf(root.`val`), sum)
        pathChild(root.right, mutableListOf(root.`val`), sum)
        return count
    }
    
    fun pathChild(current: TreeNode?, vals: MutableList<Int>, sum: Int) {
        if (current == null) return
        
        val parentVals = vals.map { it + current.`val` }.toMutableList()
        parentVals.add(current.`val`)
        count += parentVals.count{ it == sum }
        
        pathChild(current.left, parentVals, sum)
        pathChild(current.right, parentVals, sum)
    }
}
