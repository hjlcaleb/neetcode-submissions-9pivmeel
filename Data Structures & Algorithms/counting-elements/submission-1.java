class Solution {
    public int countElements(int[] arr) {
        int count = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : arr) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        for (int n : counts.keySet()) {
            if (counts.containsKey(n + 1)) {
                for (int i = 0; i < counts.get(n); i++) {
                    count++;
                }
            }
        }
        return count;
    }
}
