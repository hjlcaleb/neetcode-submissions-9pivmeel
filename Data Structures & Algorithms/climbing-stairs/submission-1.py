class Solution:
    def climbStairs(self, n: int) -> int:
        first, second = 1, 1

        i = 2
        while i <= n:
            temp = first
            first = second
            second += temp
            i += 1
        
        return second