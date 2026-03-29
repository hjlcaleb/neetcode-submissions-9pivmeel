class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = -1;
        int result = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > hi) {
                hi = piles[i];
            }
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }
            if (totalTime > h) {
                lo = mid + 1;
            } else if (totalTime <= h) {
                hi = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}
