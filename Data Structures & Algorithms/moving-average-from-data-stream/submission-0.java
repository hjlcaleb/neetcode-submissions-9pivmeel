class MovingAverage {
    private Deque<Integer> q;
    private int size;
    private int curSum;

    public MovingAverage(int size) {
        this.q = new ArrayDeque<>();
        this.size = size;
        this.curSum = 0;
    }
    
    public double next(int val) {
        q.addLast(val);
        curSum += val;

        if (size < q.size()) {
            curSum -= q.removeFirst();
        }

        return (double) curSum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
