class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        
        Arrays.sort(arr, (a, b) -> {
            int freqA = freq.get(a), freqB = freq.get(b);
            if (freqA != freqB) return Integer.compare(freqA, freqB);
            return Integer.compare(b, a);
        });

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }

        return res;
    }
}