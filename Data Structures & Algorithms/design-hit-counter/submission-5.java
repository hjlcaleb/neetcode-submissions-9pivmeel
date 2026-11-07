class HitCounter {
    private int[] hits;
    private int[] recentTimes;
    private static final int LOOKBACK_PERIOD = 300;

    public HitCounter() {
        hits = new int[LOOKBACK_PERIOD];
        recentTimes = new int[LOOKBACK_PERIOD];
    }
    
    public void hit(int timestamp) {
        int key = timestamp % LOOKBACK_PERIOD;
        if (recentTimes[key] == timestamp) {
            hits[key]++;
        } else {
            hits[key] = 1;
            recentTimes[key] = timestamp;
        }
    }
    
    public int getHits(int timestamp) {
        int totalHits = 0;
        for (int i = 0; i < LOOKBACK_PERIOD; i++) {
            if (timestamp - recentTimes[i] < LOOKBACK_PERIOD) {
                totalHits += hits[i];
            }
        }
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
