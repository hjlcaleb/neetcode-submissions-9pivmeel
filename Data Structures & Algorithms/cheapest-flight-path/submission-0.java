class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] prices = new int[n];
        Arrays.fill(prices, INF);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int cost = flight[2];
                if(prices[s] == INF) {
                    continue;
                } 
                tmpPrices[d] = Math.min(tmpPrices[d], prices[s] + cost);
            }
            prices = tmpPrices;
        }
        if (prices[dst] == INF) {
            return -1;
        }
        return prices[dst];
    }
}
