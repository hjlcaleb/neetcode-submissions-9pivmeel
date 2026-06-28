class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != nums[k]) {
                k++;
                nums[k] = nums[r];
            }
        }
        return k + 1;
    }
}