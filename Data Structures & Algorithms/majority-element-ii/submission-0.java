class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int threshold = nums.length / 3;
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> majorityElements = new ArrayList<>();
        for (int n : nums) {
            freq.putIfAbsent(n, 0);
            freq.put(n, freq.get(n) + 1);
        }

        for (int n : freq.keySet()) {
            if (freq.get(n) > threshold) {
                majorityElements.add(n);
            }
        }

        return majorityElements;
    }
}