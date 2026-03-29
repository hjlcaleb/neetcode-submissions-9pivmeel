class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = Integer.MAX_VALUE;
        
        // find upper bound
        int maxH = -1;
        for (int p : piles) {
            if (p > maxH) {
                maxH = p;
            }
        }

        int l = 1;
        int r = maxH;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (isValidRate(piles, mid, h)) {
                k = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }

    private boolean isValidRate(int[] piles, int rate, int h) {
        int hoursSpent = 0;
        for (int i = 0; i < piles.length; i++) {
            hoursSpent += Math.ceil((double)piles[i] / rate);
        }
        return hoursSpent <= h;
    }
}
