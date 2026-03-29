class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double dist = Math.sqrt(x * x + y * y);
            maxHeap.add(new double[]{x, y, dist});
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            double[] pair = maxHeap.remove();
            result[i][0] = (int)pair[0];
            result[i][1] = (int)pair[1];
        }
        return result;
    }
}
