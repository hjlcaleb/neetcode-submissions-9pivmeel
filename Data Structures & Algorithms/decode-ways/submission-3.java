class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length()) {
                    if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            } else {
                dp[i] = 0;
            }
        }
        return dp[0];
    }
}
