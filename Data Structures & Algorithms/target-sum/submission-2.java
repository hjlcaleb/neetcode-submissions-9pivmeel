class Solution {
    int totalSum;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int n : nums) totalSum += n;
        dp = new int[nums.length][2 * totalSum + 1];
                
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int i, int curSum, int target) {
        if (i >= nums.length) {
            return (curSum == target) ? 1 : 0;
        }

        if (dp[i][curSum + totalSum] != Integer.MIN_VALUE) return dp[i][curSum + totalSum];
        
        dp[i][curSum + totalSum] = dfs(nums, i + 1, curSum + nums[i], target) + 
            dfs(nums, i + 1, curSum - nums[i], target);

        return dp[i][curSum + totalSum];
    }
}
