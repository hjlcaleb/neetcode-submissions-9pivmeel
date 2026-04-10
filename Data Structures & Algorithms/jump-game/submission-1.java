class Solution {
    public boolean canJump(int[] nums) {
        int curPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > curPos) return false;
            curPos = Math.max(curPos, i + nums[i]);
        }
        return curPos >= nums.length - 1;
    }
}
