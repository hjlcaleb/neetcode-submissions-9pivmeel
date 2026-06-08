class Solution {  
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tempPrices = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];

                if (tempPrices[u] != Integer.MAX_VALUE) {
                    prices[v] = Math.min(prices[v], tempPrices[u] + price);
                }
            }
        }
        return (prices[dst] != Integer.MAX_VALUE) ? prices[dst] : -1;
    }
}
