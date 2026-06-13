class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;
        image[sr][sc] = color;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            for (int[] dir : directions) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length
                    && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}