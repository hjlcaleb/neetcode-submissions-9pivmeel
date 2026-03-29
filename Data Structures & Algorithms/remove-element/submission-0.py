class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        temp = []
        for n in nums:
            if n == val:
                continue
            temp.append(n)

        for i in range(len(temp)):
            nums[i] = temp[i]
        
        return len(temp)