class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = (x * x + y * y);
            maxHeap.add(new int[]{x, y, dist});
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] pair = maxHeap.remove();
            result[i][0] = pair[0];
            result[i][1] = pair[1];
        }
        return result;
    }
}
