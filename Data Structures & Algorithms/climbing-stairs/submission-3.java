class Solution {
    private int[] memo;
    private int n;

    public int climbStairs(int n) {
        memo = new int[n];
        Arrays.fill(memo, -1);
        this.n = n;
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (memo[i] != -1) return memo[i];
        memo[i] = dfs(i + 1) + dfs(i + 2);
        return memo[i];
    }
}
