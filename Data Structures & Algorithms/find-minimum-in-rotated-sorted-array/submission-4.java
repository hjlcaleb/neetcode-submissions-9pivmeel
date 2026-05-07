class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int result = nums[0];
        
        if (nums[l] <= nums[r]) return result;

        while (l <= r) {
            int mid = (l + r) / 2;
            result = Math.min(nums[mid], result);
            if (nums[0] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
