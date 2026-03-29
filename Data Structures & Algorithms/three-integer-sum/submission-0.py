class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # 0. sort list of numbers to determine duplicates
        # 1. find our nums[i]
        # 2. treat -nums[i] as a target value
        # 3. check two values nums[j] and nums[k] that equal -nums[i]
        # 4. adjust j, k pointers, accounting for duplicates
        # 5. adjust i, accounting for duplicates 
        
        res = []
        nums.sort()

        for i, a in enumerate(nums):
            if i > 0 and a == nums[i - 1]:
                continue
            
            j, k = i + 1, len(nums) - 1

            while j < k:
                threeSum = nums[i] + nums[j] + nums[k]
                if threeSum > 0:
                    k -= 1
                elif threeSum < 0:
                    j += 1
                else:
                    res.append([nums[i], nums[j], nums[k]])
                    j += 1
                    while nums[j] == nums[j - 1] and j < k:
                        j += 1
        return res


            