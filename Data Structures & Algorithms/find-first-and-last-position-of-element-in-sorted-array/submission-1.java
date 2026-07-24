class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);
        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target, boolean leftBias) {
        int l = 0;
        int r = nums.length - 1;
        int i = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                i = mid;
                if (leftBias) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return i;
    }
}