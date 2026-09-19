class Solution {
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int islandCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(r, c);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void dfs(int r, int c) {
        if (!(r >= 0 && r < grid.length) || !(c >= 0 && c < grid[0].length)
            || grid[r][c] == '0') {
            
            return;
        }

        grid[r][c] = '0';
        dfs(r + 1, c);
        dfs(r, c + 1);
        dfs(r - 1, c);
        dfs(r, c - 1);
    }
}
