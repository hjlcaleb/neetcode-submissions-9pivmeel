class HitCounter {
    private Queue<Integer> stream;
    public HitCounter() {
        this.stream = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        stream.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!stream.isEmpty()) {
            int diff = timestamp - stream.peek();
            if (diff >= 300) {
                stream.remove();
            } else {
                break;
            }
        }
        return stream.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
