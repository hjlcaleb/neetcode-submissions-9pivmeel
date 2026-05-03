class Solution {
    private int[] nums;
    private int[][] memo;
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length][nums.length + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dfs(nums.length - 1, nums.length);
    }

    // what's the length of the maximum increasing subsequence from 0,...,i 
    // where every element of the sequence is at most upperBound?
    private int dfs(int i, int j) {
        if (i < 0) return 0;

        if (memo[i][j] != -1) return memo[i][j];
        
        int upperBound = (j == nums.length) ? Integer.MAX_VALUE : nums[j];

        if (i == 0) {
            if (nums[i] < upperBound) {
                return 1;
            } else {
                return 0;
            }
        }

        if (nums[i] >= upperBound) {
            return dfs(i - 1, j);
        }

        memo[i][j] = Math.max(1 + dfs(i - 1, i), dfs(i - 1, j));
        return memo[i][j];

    }
}
