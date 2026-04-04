class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> freq = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            freq.add(new ArrayList<>());
        }

        for (int element : counts.keySet()) {
            freq.get(counts.get(element)).add(element);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0; i--) {
            List<Integer> elements = freq.get(i);
            for (int element : elements) {
                res[index++] = element;
                if (index == res.length) {
                    return res;
                }
            }
        }
        return res;
    }
}
