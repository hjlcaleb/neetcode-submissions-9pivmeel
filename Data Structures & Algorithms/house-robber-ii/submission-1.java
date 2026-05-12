class Solution {
    private int[] nums;
    private int[][] memo;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        this.nums = nums;
        memo = new int[2][nums.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return Math.max(dfs(0, 1), dfs(1, 0));
    }

    private int dfs(int i, int firstHouseRobbed) {
        if (i >= nums.length || (firstHouseRobbed == 1 && i == nums.length - 1)) {
            return 0;
        }

        if (memo[firstHouseRobbed][i] != -1) return memo[firstHouseRobbed][i];
        if (i == 0) {
            if (firstHouseRobbed == 1) {
                memo[firstHouseRobbed][i] = nums[i] + dfs(i + 2, 1);
            } else {
                memo[firstHouseRobbed][i] = dfs(i + 1, 0);
            }
        } else {
            memo[firstHouseRobbed][i] = Math.max(nums[i] + dfs(i + 2, firstHouseRobbed), 
                dfs(i + 1, firstHouseRobbed)
            );
        }
        
        return memo[firstHouseRobbed][i];
    }
}
