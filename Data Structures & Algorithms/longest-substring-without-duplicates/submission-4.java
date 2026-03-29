class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> soFar = new HashSet<>();
        int maxLength = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            if (!soFar.contains(s.charAt(r))) {
                soFar.add(s.charAt(r));
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            } else {
                soFar.remove(s.charAt(l));
                l++;
            }
            
        }
        return maxLength;
    }
}
