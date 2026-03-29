class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        
        for i, n in enumerate(nums):
            if(i > 0 and n == nums[i - 1]):
                continue
            
            
            j = i + 1
            k = len(nums) - 1

            while j < k:
                threeSum = nums[i] + nums[j] + nums[k]

                if threeSum < 0:
                    j += 1
                elif threeSum > 0:
                    k -= 1
                else:
                    res.append([nums[i], nums[j], nums[k]])
                    j += 1
                    while (nums[j] == nums[j-1] and j < k):
                        j += 1
        
        return res
        

