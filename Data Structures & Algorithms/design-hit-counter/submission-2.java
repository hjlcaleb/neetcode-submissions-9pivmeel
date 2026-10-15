class HitCounter {
    private int[] time;
    private int[] counts;

    public HitCounter() {
        time = new int[300];
        counts = new int[300];
    }
    
    public void hit(int timestamp) {
        int key = timestamp % 300;
        if (time[key] != timestamp) {
            time[key] = timestamp;
            counts[key] = 1;
        } else {
            counts[key]++;
        }
    }
    
    public int getHits(int timestamp) {
        int hits = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - time[i] < 300) {
                hits += counts[i];
            }
        }
        return hits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
