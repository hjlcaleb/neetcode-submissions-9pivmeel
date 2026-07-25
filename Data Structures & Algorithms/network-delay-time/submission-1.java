class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.add(new int[]{k, 0});

        int min = 0;
        Set<Integer> visited = new HashSet<>();
        while (!minHeap.isEmpty()) {
            int[] curNode = minHeap.remove();
            if (visited.contains(curNode[0])) continue;
            visited.add(curNode[0]);
            min = curNode[1];
            for (int[] neighbor : adj.getOrDefault(curNode[0], new ArrayList<>())) {
                minHeap.add(new int[]{neighbor[0], curNode[1] + neighbor[1]});
            }
        }

        return (visited.size() == n) ? min : -1;
    }
}
