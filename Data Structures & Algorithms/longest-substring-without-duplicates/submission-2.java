class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> soFar = new HashSet<>();
        int maxLength = 0;
        int l = 0;
        int r = l;
        while (r < s.length()) {
            if (soFar.contains(s.charAt(r))) {
                soFar.remove(s.charAt(l));
                l++;
            } else {
                soFar.add(s.charAt(r));
                maxLength = Math.max(r - l + 1, maxLength);
                r++;
            }
        }
        return maxLength;
    }
}
