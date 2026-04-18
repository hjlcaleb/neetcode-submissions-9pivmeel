class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = l;
        Set<Character> seen = new HashSet<>();
        int longest = 0;
        while (r < s.length()) {
            while(seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            longest = Math.max(r - l + 1, longest); 
            r++;
        }
        return longest;
    }
}
