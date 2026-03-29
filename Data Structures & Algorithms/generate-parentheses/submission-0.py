class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # start with open parentheses  
        # add open parentheses if # open <= n 
        # closing parentheses must be < open parentheses
        # # open = # close = n
        
        stack = []
        res = []

        # recursive function:
        def backtrack(openN, closedN):
            if openN == closedN == n:
                res.append("".join(stack))
                return
            
            if openN < n:
                stack.append("(")
                backtrack(openN + 1, closedN)
                stack.pop()

            if closedN < openN:
                stack.append(")")
                backtrack(openN, closedN + 1)
                stack.pop()
        
        backtrack(0,0)
        return res



        