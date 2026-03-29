class KthLargest {
    private PriorityQueue<Integer> kthLargest;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        kthLargest = new PriorityQueue<>();
        for (int n : nums) {
            kthLargest.add(n);
            if (kthLargest.size() > k) {
                kthLargest.remove();
            }
        }
    }
    
    public int add(int val) {
        kthLargest.add(val);
        if (kthLargest.size() > k) {
            kthLargest.remove();
        }
        return kthLargest.peek();
    }
}
