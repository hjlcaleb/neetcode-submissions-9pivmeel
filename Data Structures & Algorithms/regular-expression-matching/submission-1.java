class Solution {
    private String s;
    private String p;
    
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return regex(0, 0);
    }
    
    private boolean regex(int i, int j) {
        if (j >= p.length()) {
            return (i == s.length());
        }

        boolean firstMatch = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return regex(i, j + 2) || firstMatch && regex(i + 1, j);
        }

        return firstMatch && regex(i + 1, j + 1);
    }
}
