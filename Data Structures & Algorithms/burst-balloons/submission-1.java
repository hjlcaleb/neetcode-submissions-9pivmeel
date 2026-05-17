class Solution {
    private int[] newNums;
    private int[][] memo;

    public int maxCoins(int[] nums) {
        newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            newNums[i] = nums[i - 1];
        }

        memo = new int[nums.length + 2][nums.length + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return burstBalloons(1, nums.length);
    }

    private int burstBalloons(int l, int r) {
        if (l > r) {
            return 0;
        }

        if (memo[l][r] != -1) return memo[l][r];

        memo[l][r] = 0;
        for (int k = l; k <= r; k++) {
            int coins = burstBalloons(l, k - 1) + newNums[l - 1] * newNums[k] * newNums[r + 1]
                + burstBalloons(k + 1, r);
            memo[l][r] = Math.max(memo[l][r], coins);
        }
        return memo[l][r];
    }
}
