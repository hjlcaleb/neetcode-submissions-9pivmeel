class HitCounter {
    private Queue<Integer> queue;
    private final int LOOKBACK_PERIOD = 300;
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        queue.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= LOOKBACK_PERIOD) {
            queue.remove();
        }
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
