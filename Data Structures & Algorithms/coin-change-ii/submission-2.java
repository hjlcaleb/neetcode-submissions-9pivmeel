class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int r = 0; r < dp.length; r++) {
            dp[r][0] = 1;
            for (int c = 1; c < dp[0].length; c++) {
                int include = 0;
                int skip = 0;

                if (c - coins[r] >= 0) {
                    include = dp[r][c - coins[r]];
                }

                if (r - 1 >= 0) {
                    skip = dp[r - 1][c];
                }

                dp[r][c] = include + skip;
            }
        }
        return dp[coins.length - 1][amount];
    }
}
