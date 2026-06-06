class Solution {
    private String s;
    private String p;
    private Boolean[][] memo;
    
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.memo = new Boolean[s.length() + 1][p.length() + 1];
        return regex(0, 0);
    }
    
    private boolean regex(int i, int j) {
        if (j >= p.length()) {
            return (i == s.length());
        }

        if (memo[i][j] != null) return memo[i][j];

        boolean firstMatch = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return memo[i][j] = regex(i, j + 2) || firstMatch && regex(i + 1, j);
        }

        return memo[i][j] = firstMatch && regex(i + 1, j + 1);
    }
}
