class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        for (int n : nums) {
            currentSum += n;
            if (prefixSums.containsKey(currentSum - k)) {
                res += prefixSums.get(currentSum - k);
            }
            prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);
        }
        return res;
    }
} 