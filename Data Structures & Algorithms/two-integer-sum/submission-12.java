class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numToIndex.containsKey(diff)) {
                res[0] = numToIndex.get(diff);
                res[1] = i;
                return res;
            }
            numToIndex.put(nums[i], i);
        }

        return res;
    }
}