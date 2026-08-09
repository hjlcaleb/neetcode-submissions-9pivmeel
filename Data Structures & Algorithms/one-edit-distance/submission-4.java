class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.equals(t)) return false;
        int i = 0;
        int j = 0;
        boolean edited = false;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (edited) return false;
                if (s.length() < t.length()) {
                    j++;
                    edited = true;
                } else if (s.length() > t.length()) {
                    i++;
                    edited = true;
                } else {
                    i++;
                    j++;
                    edited = true;
                }
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}