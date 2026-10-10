class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(r, c, grid, 
                        grid.length, grid[0].length, directions));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int r, int c, int[][] grid, int n, int m, int[][] directions) {
        if (grid[r][c] == 0) {
            return 0;
        }

        int area = 1;
        grid[r][c] = 0;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                area += dfs(nr, nc, grid, n, m, directions);
            }
        }

        return area;
    }
}
