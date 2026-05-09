class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int pivot = (l + r) / 2;
            if (nums[pivot] == target) {
                return true;
            }

            if (nums[l] == nums[pivot] && nums[r] == nums[pivot]) {
                l++;
                r--;
            } else if (nums[l] <= nums[pivot]) {
                if (target < nums[l] || target > nums[pivot]) {
                    l = pivot + 1;
                } else {
                    r = pivot - 1;
                }
            } else {
                if (target > nums[r] || target < nums[pivot]) {
                    r = pivot - 1;
                } else {
                    l = pivot + 1;
                }
            }
        }
        return false;
    }
}