class Solution:
    def maxArea(self, heights: List[int]) -> int:
        front, back = 0, len(heights) - 1
        maxArea = 0

        while front < back:
            if heights[front] < heights[back]: # LR: front
                maxArea = max(maxArea, heights[front] * (back - front))
                front += 1
            elif heights[front] >= heights[back]: # LR: back
                maxArea = max(maxArea, heights[back] * (back - front)) 
                back -= 1
        
        return maxArea
             

        