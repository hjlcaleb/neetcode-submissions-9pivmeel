class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int l = 0;
        int r = l + k - 1;
        int[] windowMaxes = new int[nums.length - k + 1];

        for (int i = 0; i < k - 1; i++) {
            maxHeap.add(nums[i]);
        }

        while (r < nums.length) {
            maxHeap.add(nums[r]);
            windowMaxes[l] = maxHeap.peek();
            maxHeap.remove(nums[l]);
            l++;
            r++;
        }
        return windowMaxes;
    }
}
