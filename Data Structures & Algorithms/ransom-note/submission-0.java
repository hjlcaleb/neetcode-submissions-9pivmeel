class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] ransom = new int[26];
        int[] mag = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ransom[(int)(ransomNote.charAt(i) - 'a')]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            mag[(int)(magazine.charAt(i) - 'a')]++;
        }

        for (int i = 0; i < 26; i++) {
            if (mag[i] < ransom[i]) return false;
        }
        return true;
    }
}