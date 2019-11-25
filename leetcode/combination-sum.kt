/**
 * 문제: https://leetcode.com/problems/combination-sum
 * 풀이: https://bcp0109.tistory.com/127
 */

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()

        fun backtracking(index: Int, list: ArrayList<Int>, newTarget : Int) {
            if (newTarget == 0) {
                result.add(list.toList())
                return
            }

            for (i in index until candidates.size) {
                val item = candidates[i]
                
                if (item <= newTarget) {
                    list.add(item)
                    backtracking(i, list, newTarget - item)
                    list.remove(item)
                }
            }
        }

        candidates.forEachIndexed { index, value ->
            backtracking(index, arrayListOf(value), target - value)
        }

        return result
    }
}
