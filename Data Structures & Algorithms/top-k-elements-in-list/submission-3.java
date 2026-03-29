class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        // populate map of numbers to how many times they appear
        for (int n : nums) {
            numToFreq.putIfAbsent(n, 0);
            numToFreq.put(n, numToFreq.get(n) + 1);
        }

        // next, populate reverse-histogram (frequencies to list of numbers) from map
        List<List<Integer>> freq = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            freq.add(new ArrayList<Integer>());
        }

        for (int num : numToFreq.keySet()) {
            freq.get(numToFreq.get(num)).add(num);
        }

        // return the k most frequent elements (top k frequencies)
        int[] result = new int[k];
        int index = 0;
        for (int i = freq.size() - 1; i > 0 && index < k; i--) {
            for (int num : freq.get(i)) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}