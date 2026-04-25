class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderToIndex = new HashMap<>();
        remainderToIndex.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int curRemainder = runningSum % k;
            if (!remainderToIndex.containsKey(curRemainder)) {
                remainderToIndex.put(curRemainder, i);
            } else {
                if (i - remainderToIndex.get(curRemainder) >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}