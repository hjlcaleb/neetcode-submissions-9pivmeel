class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] freq = new int[26];
        int max = 0;
        int numDistinct = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (freq[c - 'a'] == 0) {
                numDistinct++;
            }
            freq[c - 'a']++;

            while (numDistinct > k) {
                char rm = s.charAt(l);
                freq[rm - 'a']--;
                l++;
                if (freq[rm - 'a'] == 0) {
                    numDistinct--;
                }
            }

            max = Math.max(r - l + 1, max);
        }
        return max;
    }
}
