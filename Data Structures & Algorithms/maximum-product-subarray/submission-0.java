class Solution {
    private int[] nums;
    private int globalMax;

    public int maxProduct(int[] nums) {
        this.nums = nums;
        globalMax = nums[0];
        dfs(nums.length - 1);
        return globalMax;
    }

    private int[] dfs(int i) {
        if (i == 0) return new int[]{nums[0], nums[0]};

        int[] prev = dfs(i - 1);
        int prevMax = prev[0];
        int prevMin = prev[1];

        int curMax = Math.max(nums[i], Math.max(nums[i] * prevMax, nums[i] * prevMin));
        int curMin = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * prevMin));
        
        globalMax = Math.max(globalMax, curMax);
        return new int[]{curMax, curMin};
    }
}
