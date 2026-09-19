class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);

            if (l > deque.getFirst()) {
                deque.removeFirst();
            }

            if (r - l + 1 == k) {
                result[l] = nums[deque.getFirst()];
                l++;
            }
        }
        return result;
    }
}
