class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int pivot = (l + r) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            
            // left sorted portion
            if (nums[l] <= nums[pivot]) {
                if (target > nums[pivot] || target < nums[l]) {
                    l = pivot + 1;
                } else {
                    r = pivot - 1;
                }
            // right sorted portion
            } else {
                if (target < nums[pivot] || target > nums[r]) {
                    r = pivot - 1;
                } else {
                    l = pivot + 1;
                }
            }
        }

        return -1;
    }
}
