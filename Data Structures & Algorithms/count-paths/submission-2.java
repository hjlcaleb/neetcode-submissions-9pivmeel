class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}};
        grid[m - 1][n - 1] = 1;
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r + 1 < m) {
                    grid[r][c] += grid[r + 1][c];
                }

                if (c + 1 < n) {
                    grid[r][c] += grid[r][c + 1];
                }
            }
        }
        return grid[0][0];
    }
}
