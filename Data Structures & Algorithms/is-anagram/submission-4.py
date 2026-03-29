class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dict_1 = {}
        dict_2 = {}

        for c in s:
            dict_1.setdefault(c, 0)
            dict_1[c] += 1
        for c in t:
            dict_2.setdefault(c, 0)
            dict_2[c] += 1

        return dict_1 == dict_2
