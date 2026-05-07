class MovingAverage {
    private int[] window;
    private int size;
    private int count;
    private int head;
    private int curSum;

    public MovingAverage(int size) {
        this.window = new int[size];
        this.size = size;
        this.count = 0;
        this.head = 0;
        this.curSum = 0;
    }
    
    public double next(int val) {
        int index = head % size;
        curSum -= window[index];

        window[index] = val;
        curSum += val;

        head++;        

        count = Math.min(count + 1, size);
        return (double) curSum / count;

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
