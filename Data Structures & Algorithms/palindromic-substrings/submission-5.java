class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j || (j == i + 1 && s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;
                    count++;
                } else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                    count += (dp[i][j]) ? 1 : 0;
                }
            }
        }
        return count;
    }
}
