class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0

        maxLength = 0
        uniqueChars = set()
        l = 0

        for r in range(len(s)):
            while s[r] in uniqueChars:
                uniqueChars.remove(s[l])
                l += 1
            maxLength = max(maxLength, r - l + 1)
            uniqueChars.add(s[r])
        
        return maxLength

