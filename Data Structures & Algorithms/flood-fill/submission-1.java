class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cell = q.remove();
            int oldColor = image[cell[0]][cell[1]];
            image[cell[0]][cell[1]] = color;
            visited[cell[0]][cell[1]] = true;
            for (int[] dir : directions) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length
                    && image[nr][nc] == oldColor && !visited[nr][nc]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}