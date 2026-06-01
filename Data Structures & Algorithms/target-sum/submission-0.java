class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int i, int curSum, int target) {
        if (i >= nums.length) {
            return (curSum == target) ? 1 : 0;
        }

        return dfs(nums, i + 1, curSum + nums[i], target) + dfs(nums, i + 1, curSum - nums[i], target);
    }
}
