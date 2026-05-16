class Solution {
    private int m;
    private int n;
    private int[][] directions;
    private int[][] grid;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        directions = new int[][]{{0, 1}, {1, 0}};
        grid = new int[m][n];
        return dfs(0, 0);
    }

    private int dfs(int r, int c) {
        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        if (!(r >= 0 && r < m) || !(c >= 0 && c < n)) {
            return 0;
        }

        if (grid[r][c] != 0) {
            return grid[r][c];
        }

        for (int[] dir : directions) {
            grid[r][c] += dfs(r + dir[0], c + dir[1]);
        }
        
        return grid[r][c];
    }
}
