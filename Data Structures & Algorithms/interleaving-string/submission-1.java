class Solution {
    private String s1;
    private String s2;
    private String s3;
    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i + j >= s3.length()) return true;
        
        if (memo[i][j] != null) return memo[i][j];

        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res = res || dfs(i + 1, j);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res = res || dfs(i, j + 1);
        }

        return memo[i][j] = res;
    }
}
