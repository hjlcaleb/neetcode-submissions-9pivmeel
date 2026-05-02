class Solution {
    private int[] memo;
    private int[] cost;

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        this.cost = cost;
        Arrays.fill(memo, -1);
        return Math.min(dfs(0), dfs(1));
    }

    private int dfs(int i) {
        if (i >= cost.length) {
            return 0;
        }

        if (memo[i] != -1) return memo[i];

        memo[i] = Math.min(cost[i] + dfs(i + 1), cost[i] + dfs(i + 2));
        return memo[i];
    }
}
