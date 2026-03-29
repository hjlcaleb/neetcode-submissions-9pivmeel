class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsToFreq = new HashMap<>();
        for (int num : nums) {
            numsToFreq.put(num, numsToFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> kMostFrequent = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int num : numsToFreq.keySet()) {
            kMostFrequent.add(new int[]{num, numsToFreq.get(num)});
            if (kMostFrequent.size() > k) {
                kMostFrequent.remove();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = kMostFrequent.remove()[0];
        }
        return result;
    }
}
