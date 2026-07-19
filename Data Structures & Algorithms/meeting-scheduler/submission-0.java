class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> candidates = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) candidates.add(slot);
        }

        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) candidates.add(slot);
        }

        while (candidates.size() > 1) {
            int[] slot1 = candidates.remove();
            int[] slot2 = candidates.peek();
            if (slot1[1] >= slot2[0] + duration) {
                return Arrays.asList(slot2[0], slot2[0] + duration);
            }
        }
        return new ArrayList<>();
    }
}
