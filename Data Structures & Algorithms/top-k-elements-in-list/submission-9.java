class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> histogram = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            histogram.add(new ArrayList<>());
        }

        for (int element : counts.keySet()) {
            histogram.get(counts.get(element)).add(element);
        }

        int[] res = new int[k];
        int kPtr = k - 1;
        
        for (int i = histogram.size() - 1; i >= 0 && kPtr >= 0; i--) {
            for (int j = 0; j < histogram.get(i).size() && kPtr >= 0; j++) {
                res[kPtr--] = histogram.get(i).get(j);
            }
        }
        return res;
    }
}
