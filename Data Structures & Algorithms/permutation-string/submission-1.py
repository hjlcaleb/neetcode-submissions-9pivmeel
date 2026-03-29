class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        # Frequency count for s1
        target = [0] * 26
        for c in s1:
            target[ord(c) - ord('a')] += 1
        
        # Sliding window over s2
        window = [0] * 26
        l = 0

        for r in range(len(s2)):
            # Add current character to the window
            window[ord(s2[r]) - ord('a')] += 1

            # Keep window size equal to len(s1)
            if r - l + 1 > len(s1):
                window[ord(s2[l]) - ord('a')] -= 1
                l += 1
            
            # Compare window with target
            if window == target:
                return True

        return False
