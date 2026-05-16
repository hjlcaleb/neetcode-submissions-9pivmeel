class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int prevMin = dp[0][i - 1];
            int prevMax = dp[1][i - 1];

            dp[0][i] = Math.min(nums[i], Math.min(nums[i] * prevMin, nums[i] * prevMax));
            dp[1][i] = Math.max(nums[i], Math.max(nums[i] * prevMin, nums[i] * prevMax));

            result = Math.max(result, dp[1][i]);
        }

        return result;
    }
}
