class Solution {
    private static int[][] directions;
    private boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int original, int newColor) {
        image[r][c] = newColor;
        visited[r][c] = true;
        
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if ((nr >= 0 && nr < image.length) &&
                (nc >= 0 && nc < image[0].length)
                && image[nr][nc] == original
                && !visited[nr][nc]) {
                dfs(image, nr, nc, original, newColor);
            }
        }
    }
}