class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # handle the rotation by finding deflection point

        l, r = 0, len(nums) - 1
        
        while l < r:
            mid = l + ((r - l) // 2)

            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid

        pivot = l

        # handle the sort

        def binary_search(left: int, right: int) -> int:
            while left <= right:
                mid = left + ((right - left) // 2)

                if target < nums[mid]:
                    right = mid - 1
                elif target > nums[mid]:
                    left = mid + 1
                else:
                    return mid

            return -1
        
        if target >= nums[pivot] and target <= nums[len(nums) - 1]:
            return binary_search(pivot, len(nums) - 1)
        else:
            return binary_search(0, pivot - 1)    

