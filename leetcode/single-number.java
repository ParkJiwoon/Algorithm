/**
 * 문제: https://leetcode.com/problems/single-number
 * 풀이: https://bcp0109.tistory.com/140
 */ 

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}
