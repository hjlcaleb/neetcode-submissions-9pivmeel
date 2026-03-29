class Solution {
    public int singleNumber(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target = target ^ num;
        }
        return target;
    }
}
