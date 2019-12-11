/**
 * 문제: https://leetcode.com/problems/sort-colors/
 * 풀이: https://bcp0109.tistory.com/144
 */
 
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        for (int i=0; i<=right; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left++);
            }
            
            if (nums[i] == 2) {
                swap(nums, i--, right--);
            }
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
