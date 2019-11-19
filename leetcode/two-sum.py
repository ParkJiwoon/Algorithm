class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        _dict = {}
        
        for index in range(len(nums)):
            value = nums[index]
            
            if (target - value) in _dict:
                return [_dict[target - value], index]
            
            _dict[value] = index
