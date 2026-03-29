class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int n : nums) {
            numToFreq.put(n, numToFreq.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> freqToNums = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            freqToNums.add(new ArrayList<>());
        }
        for (int n : numToFreq.keySet()) {
            freqToNums.get(numToFreq.get(n)).add(n);
        }

        int[] res = new int[k];
        int kthElement = 0;
        for (int i = freqToNums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < freqToNums.get(i).size(); j++) {
                res[kthElement++] = freqToNums.get(i).get(j);
                if (kthElement == k) return res;
            }
        }
        return res;
    }
}
