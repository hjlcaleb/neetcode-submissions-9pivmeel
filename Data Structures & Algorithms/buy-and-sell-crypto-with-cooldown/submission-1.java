class Solution {
    private int[] prices;
    private int[][] memo;
    
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[2][prices.length];
        return dfs(0, 1);
    }

    private int dfs(int i, int canBuy) { // 1 = yes, 0 = n
        if (i >= prices.length) return 0;
        if (memo[canBuy][i] != 0) return memo[canBuy][i];

        int skip = dfs(i + 1, canBuy);
        if (canBuy == 1) {
            int buy = dfs(i + 1, 0) - prices[i];
            memo[canBuy][i] = Math.max(buy, skip);
            return Math.max(buy, skip);
        } else {
            int sell = dfs(i + 2, 1) + prices[i];
            memo[canBuy][i] = Math.max(sell, skip);
            return memo[canBuy][i];
        }
    }
}
