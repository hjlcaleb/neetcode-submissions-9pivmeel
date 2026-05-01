class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        return rob(0, nums);
    }

    private int rob(int i, int[] nums) {
        if (i >= nums.length) return 0;
        if (memo[i] != 0) return memo[i];
        memo[i] = Math.max(nums[i] + rob(i + 2, nums), rob(i + 1, nums));
        return memo[i];
    }
}
