// https://leetcode.com/problems/two-sum

// O(n^2)
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { i, iNum ->
            nums.forEachIndexed { j, jNum ->
                if (i != j && iNum + jNum == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}


// O(n)
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        nums.forEachIndexed {index, value ->
            map[target - value]?.let { return intArrayOf(it, index) }
            map[value] = index
        }

        return intArrayOf()
    }
}
