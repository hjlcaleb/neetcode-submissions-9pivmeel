class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        for (int num : nums) {
            maxSum += num;
        }
        if (maxSum % 2 == 1) return false;
        
        maxSum /= 2;
        
        boolean[][] dp = new boolean[n + 1][maxSum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][maxSum];

    }
}
