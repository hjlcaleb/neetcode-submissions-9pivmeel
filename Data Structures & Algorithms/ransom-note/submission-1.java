class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] mag = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
            mag[(int)(magazine.charAt(i) - 'a')]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--mag[(int)(ransomNote.charAt(i) - 'a')] < 0) return false;
        }
        
        return true;
    }
}