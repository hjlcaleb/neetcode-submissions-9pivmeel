class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int peakCandidate = (l + r) / 2;
            if (peakCandidate > 0 && nums[peakCandidate] <= nums[peakCandidate - 1]) {
                r = peakCandidate - 1;
            } else if (peakCandidate < nums.length - 1 && nums[peakCandidate] <= nums[peakCandidate + 1]) {
                l = peakCandidate + 1;
            } else {
                return peakCandidate;
            }
        }
        return -1;
    }
}