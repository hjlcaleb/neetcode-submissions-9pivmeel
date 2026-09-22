class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int res = 0;
        int prefixSum = 0;
        for (int n : nums) {
            prefixSum += n;
            int remainder = prefixSum % k;

            if (counts.containsKey(remainder)) {
                res += counts.get(remainder);
            }

            counts.put(remainder, counts.getOrDefault(remainder, 0) + 1);
        }

        return res;
    }
}