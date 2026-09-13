class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> piles = 
            new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            piles.add(gift);
        }

        for (int i = 0; i < k; i++) {
            int val = piles.remove();
            piles.add((int) Math.floor(Math.sqrt(val)));
        }

        int sum = 0;
        while (!piles.isEmpty()) {
            sum += piles.remove();
        }
        return sum;
    }
}