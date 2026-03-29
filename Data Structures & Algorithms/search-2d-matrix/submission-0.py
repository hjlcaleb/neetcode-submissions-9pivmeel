class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top, bot = 0, len(matrix) - 1

        #perform binary search on rows --> perform binary search on col

        while top <= bot:
            row = top + ((bot - top) // 2)

            if target > matrix[row][-1] :
                top = row + 1
            elif target < matrix[row][0] :
                bot = row - 1
            else :
                break
        
        if not (top <= bot):
            return False
        
        l, r = 0, len(matrix[0]) - 1

        while l <= r:
            mid = l + ((r - l) // 2)

            if target < matrix[row][mid]:
                r = mid - 1
            elif target > matrix[row][mid]:
                l = mid + 1
            else:
                return True
        return False


