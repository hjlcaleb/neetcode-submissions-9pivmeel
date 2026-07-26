class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[n][m] = true;
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i == n && j == m) continue;
                if (i < n && s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j];
                }

                if (j < m && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] || dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
