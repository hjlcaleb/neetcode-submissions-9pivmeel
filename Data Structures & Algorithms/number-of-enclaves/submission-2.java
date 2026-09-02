class Solution {
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) dfs(grid, i, grid[0].length - 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) dfs(grid, grid.length - 1, i);
        }

        int result = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int r, int c) {
        if (!(r >= 0 && r < grid.length) || !(c >= 0 && c < grid[0].length) 
            || grid[r][c] == 0) {
            
            return;
        }

        grid[r][c] = 0;
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }
}