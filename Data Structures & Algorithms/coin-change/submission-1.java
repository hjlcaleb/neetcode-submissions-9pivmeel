class Solution {  
    public int coinChange(int[] coins, int amount) {
        int INFTY = 1000000;
        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = 0;
        }

        for (int i = 0; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                int skip = -1;
                if (i > 0) {
                    skip = memo[i - 1][j];;
                } else {
                    skip = INFTY;
                }

                int include = -1;
                if (j >= coins[i]) {
                    include = 1 + memo[i][j - coins[i]];
                } else {
                    include = INFTY;
                }

                memo[i][j] = Math.min(skip, include);
            }
        }
        return (memo[coins.length - 1][amount] != INFTY)? memo[coins.length - 1][amount] : -1;
    }
}
