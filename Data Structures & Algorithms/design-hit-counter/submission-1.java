class HitCounter {
    private int TIME_LIMIT = 300;
    private int[] times;
    private int[] counts;

    public HitCounter() {
        times = new int[TIME_LIMIT];
        counts = new int[TIME_LIMIT];
    }
    
    public void hit(int timestamp) {
        int index = timestamp % 300;
        
        if (times[index] != timestamp) {
            times[index] = timestamp;
            counts[index] = 1;
        } else {
            counts[index]++;
        }
    }
    
    public int getHits(int timestamp) {
        int totalHits = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                totalHits += counts[i];
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
