class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();
            if (stone2 != stone1) {
                maxHeap.add(Math.abs(stone2 - stone1));
            }
        }

        return (maxHeap.isEmpty()) ? 0 : maxHeap.peek();
    }
}
