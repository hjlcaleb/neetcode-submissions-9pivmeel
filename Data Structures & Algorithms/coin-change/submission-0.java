class Solution {
    private int INFTY = 1000000;
    private int[] coins;
    private int[][] memo;
    
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int minCoins = dfs(coins.length - 1, amount);
        if (minCoins == INFTY) return -1;
        return minCoins;
    }

    private int dfs(int i, int j) {
        if (j == 0) return 0;
        if (j < 0 || i < 0) {
            return INFTY;
        }

        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = Math.min(dfs(i - 1, j), 1 + dfs(i, j - coins[i]));
        return memo[i][j];
    }
}
