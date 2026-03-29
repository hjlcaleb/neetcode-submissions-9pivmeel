class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {
            ')' : '(',
            '}' : '{',
            ']' : '['
        }
        stack = []

        for c in s:
            if c in pairs:
                if stack and pairs[c] == stack[-1]:
                    stack.pop()
                else:
                    return False
            else: 
                stack.append(c)
                
        return True if not stack else False


            
