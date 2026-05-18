class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            count++;
            for (int j = i + 1; j < n; j++) {
                if (j == i + 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)
                        && dp[i + 1][j - 1] == 1) ? 1 : 0;
                }
                count += dp[i][j];
            }
        }
        return count;
    }
}
