class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int start = mid;
                while (start - 1 >= 0 && nums[mid] == nums[start - 1]) {
                    start--;
                }
                int end = mid;
                while (end + 1 < nums.length && nums[mid] == nums[end + 1]) {
                    end++;
                }
                return new int[]{start, end};
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}