class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        def findCombination(i: int, curr: List[int], total: int):
            if total == target:
                res.append(curr.copy())
                return
            if i >= len(nums) or total > target:
                return
            
            curr.append(nums[i])
            findCombination(i, curr, total + nums[i])
            curr.pop()

            findCombination(i + 1, curr, total)
        
        findCombination(0, [], 0)
        return res
