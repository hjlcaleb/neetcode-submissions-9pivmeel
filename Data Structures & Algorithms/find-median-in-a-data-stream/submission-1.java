class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        large = new PriorityQueue<>();   
    }
    
    public void addNum(int num) {
        if (large.isEmpty() || num > large.peek()) {
            large.add(num);
        } else {
            small.add(num);
        }
        
        if (Math.abs(small.size() - large.size()) > 1) {
            if (small.size() > large.size()) {
                large.add(small.remove());
            } else {
                small.add(large.remove());
            }
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        return (double)(small.peek() + large.peek()) / 2;
    }
}
