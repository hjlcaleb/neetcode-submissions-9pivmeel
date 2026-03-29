class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0;
        int r = l;
        int maxLength = 0;

        while (r < s.length()) {
            if (!seen.contains(s.charAt(r))) {
                maxLength = Math.max(maxLength, r - l + 1);
                seen.add(s.charAt(r));
                r++;
            } else {
                seen.remove(s.charAt(l));
                l++;
            }
        }
        return maxLength;
    }
}
