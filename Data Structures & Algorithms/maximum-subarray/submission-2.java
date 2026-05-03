class Solution {
    private int[] nums;
    private int[] memo;
    private int NEG_INFTY = -1000000;
    private int globalMax;
    
    public int maxSubArray(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        globalMax = nums[0];
        Arrays.fill(memo, NEG_INFTY);
        dfs(nums.length - 1);
        return globalMax;
    }

    private int dfs(int i) {
        if (i == 0) {
            return nums[i];
        }

        if (memo[i] != NEG_INFTY) {
            return memo[i];
        }

        memo[i] = Math.max(nums[i], nums[i] + dfs(i - 1));
        globalMax = Math.max(globalMax, memo[i]);
        return memo[i];
    }
}
