class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] res = {-1, -1};
        while (l < r) {
            int sum = numbers[r] + numbers[l];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
        }
        return res;
    }
}
