class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq;
        int maxLength = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Collections.max(freq.values());
            if (r - l + 1 - maxFreq > k) {
                freq.put(s.charAt(l), freq.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            } 
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
