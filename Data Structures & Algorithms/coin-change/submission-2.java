class Solution {  
    public int coinChange(int[] coins, int amount) {
        int INFTY = 1000000;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, INFTY);
        memo[0] = 0;

        for (int i = 1; i < memo.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    memo[i] = Math.min(memo[i], 1 + memo[i - coin]);
                }
            }
        }
        return (memo[amount] == INFTY) ? -1 : memo[amount]; 
    }
}
