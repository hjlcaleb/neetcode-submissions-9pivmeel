class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            maxSum = Math.max(maxSum, curSum);

            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
