class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    exploreIsland(grid, r, c, ROWS, COLS);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }   

     void exploreIsland(char[][] grid, int x, int y, int ROWS, int COLS) {
        if (x < 0 || x >= ROWS || 
            y < 0 || y >= COLS ||
            grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        exploreIsland(grid, x - 1, y, ROWS, COLS);
        exploreIsland(grid, x + 1, y, ROWS, COLS);
        exploreIsland(grid, x, y - 1, ROWS, COLS);
        exploreIsland(grid, x, y + 1, ROWS, COLS);
    }
}
