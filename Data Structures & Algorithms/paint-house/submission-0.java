class Solution {
    private int n;
    private int[][] costs;
    private int[][] memo;

    public int minCost(int[][] costs) {
        this.n = costs.length;
        this.costs = costs;
        this.memo = new int[n + 1][3];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return paint(0, -1);
    }

    private int paint(int i, int prevColor) {
        if (i == n) {
            return 0;
        }

        if (prevColor != -1 && memo[i][prevColor] != -1) return memo[i][prevColor];
        
        int cost = Integer.MAX_VALUE;
        for (int j = 0; j <= 2; j++) {
            if (j != prevColor) {
                cost = Math.min(costs[i][j] + paint(i + 1, j), cost);
            }
        }

        if (prevColor != -1) {
            memo[i][prevColor] = cost;
        }

        return cost;
    }
}