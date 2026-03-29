class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.remove();
            }
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) { 
            heap.remove();
        }
        return heap.peek();
    }
}
