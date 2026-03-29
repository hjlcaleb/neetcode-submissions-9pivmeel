class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        int[] result = new int[2];
        // populate map
        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numToIndex.keySet().contains(diff) && numToIndex.get(diff) != i) {
                result[0] = i;
                result[1] = numToIndex.get(diff);
                break;
            }
        }
        return result;
    }
}
