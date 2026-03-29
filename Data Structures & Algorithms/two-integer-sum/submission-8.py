class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numToIndex = {}

        for i, n in enumerate(nums):
            numToIndex.update({n : i})
        
        for i, n in enumerate(nums):
            diff = target - n

            if diff in numToIndex and numToIndex[diff] != i:
                return [min(i, numToIndex[diff]), max(i, numToIndex[diff])]
        
        return []
        
            
