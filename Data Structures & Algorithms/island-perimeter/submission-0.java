class Solution {
    private int[][] grid;
    private boolean[][] visited;
    private int perimeter;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    return perimeter;
                }
            }
        }
        return perimeter;
    }

    private void dfs(int r, int c) {
        if (!(r >= 0 && r < grid.length) || !(c >= 0 && c < grid[0].length) 
            || grid[r][c] == 0) {
            perimeter += 1;
            return;
        }

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;
        dfs(r + 1, c);
        dfs(r, c + 1);
        dfs(r - 1, c);
        dfs(r, c - 1);
    }
}