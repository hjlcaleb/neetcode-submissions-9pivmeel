class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        valToIndex = {};
        for i, n in enumerate(nums):
            valToIndex[n] = i
        
        for i, n in enumerate(nums):
            diff = target - n
            if diff in valToIndex and i != valToIndex[diff]:
                return [i, valToIndex[diff]]
        
        return [];
            
