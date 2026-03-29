class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int threshold = nums.length / 3;
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> majorityElements = new ArrayList<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);

            if (freq.size() <= 2) {
                continue;
            }
            
            Map<Integer, Integer> newFreq = new HashMap<>();
            for (int num : freq.keySet()) {
                if (freq.get(num) > 1) {
                    newFreq.put(num , freq.get(num) - 1);
                }
            }
            freq = newFreq;
        }

        // verify they are greater than floor(n / 3)
        for (int candidate : freq.keySet()) {
            int actualCount = 0;
            for (int n : nums) {
                if (n == candidate) actualCount++;
            }
            if (actualCount > threshold) {
                majorityElements.add(candidate);
            }
        }

        return majorityElements;
    }
}