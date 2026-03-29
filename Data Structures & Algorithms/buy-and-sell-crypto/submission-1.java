class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int l = 0;
        int r = l + 1;
        while (r < prices.length) {
            int currProfit = prices[r] - prices[l];
            if (currProfit < 0) {
                l = r;
            } 
            r++;
            profit = Math.max(currProfit, profit);
        }
        return profit;
    }
}
