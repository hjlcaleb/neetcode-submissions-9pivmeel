class Solution {
    private int amount;
    private int[] coins;
    private int[][] memo;

    public int change(int amount, int[] coins) {
        this.amount = amount;
        this.coins = coins;
        memo = new int[coins.length][amount + 1];
        return dfs(coins.length - 1, amount);
    }

    private int dfs(int i, int target) {
        if (target == 0) {
            return 1;
        }
        
        if (target < 0 || i < 0) {
            return 0;
        }

        if (memo[i][target] != 0) return memo[i][target];

        memo[i][target] = dfs(i, target - coins[i]) + dfs(i - 1, target);
        return memo[i][target];
    }
}
