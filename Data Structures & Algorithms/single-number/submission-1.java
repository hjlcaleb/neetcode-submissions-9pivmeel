class Solution {
    public int singleNumber(int[] nums) {
        int number = 0;
        for (int n : nums) {
            number = number ^ n;
        }
        return number;
    }
}
