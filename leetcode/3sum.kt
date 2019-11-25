/**
 * 문제: https://leetcode.com/problems/3sum
 * 풀이: https://bcp0109.tistory.com/124
 */

// Brute force
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()

        nums.sort()
        nums.forEachIndexed { index, _ -> twoSum(nums, index, result) }

        return result
    }

    fun twoSum(nums: IntArray, pick: Int, result: ArrayList<List<Int>>) {
        var left = pick + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[left] + nums[right] + nums[pick]
            
            if (sum == 0) {
                val newValue = listOf(nums[left], nums[right], nums[pick])
                
                if (newValue !in result) {
                    result.add(newValue)
                }
            }

            if (sum > 0) {
                right--
            } else {
                left++
            }
        }
    }
}


// Pass duplicate value
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()

        if (nums.size < 3) return result

        nums.sort()
        nums.forEachIndexed { index, _ -> twoSum(nums, index, result) }

        return result
    }

    fun twoSum(nums: IntArray, pick: Int, result: ArrayList<List<Int>>) {
        if (pick > 0 && nums[pick] == nums[pick - 1]) return

        var left = pick + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[left] + nums[right] + nums[pick]

            if (sum == 0) {
                result.add(listOf(nums[left], nums[right], nums[pick]))
                left++
                right--
                while (nums[left] == nums[left - 1] && left < right) left++
                while (nums[right] == nums[right + 1] && left < right) right--
            }
            else if (sum > 0) right--
            else left++
        }
    }
}
