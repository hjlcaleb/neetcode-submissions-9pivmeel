class Solution:
    def minWindow(self, s: str, t: str) -> str:
        #if t == '': return ''

        charsInT, window = {}, {}
        for c in t:
            charsInT[c] = 1 + charsInT.get(c, 0)
        
        have, need = 0, len(charsInT)
        res, resLen = [-1, -1], float('infinity')
        l = 0

        for r in range(len(s)):
            c = s[r]
            window[s[r]] = 1 + window.get(c, 0)
            
            if c in charsInT and window[c] == charsInT[c]:
                have += 1
            
            while have == need:
                if r - l + 1 < resLen:
                    res = [l, r]
                    resLen = (r - l + 1)

                window[s[l]] -= 1
                if s[l] in charsInT and window[s[l]] < charsInT[s[l]]:
                    have -= 1
                l += 1

        l, r = res 
        return s[l:r + 1] if resLen != float('-infinity') else ''

            

        
            
            
        
        