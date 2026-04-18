class Solution {
    private int ROWS;
    private int COLS;
    private boolean[][] seen;
    private Set<Pair<Integer, Integer>> currentIsland;
    private int rowOrigin;
    private int colOrigin;
    private int[][] grid;
    private int[][] directions;

    public int numDistinctIslands(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        seen = new boolean[ROWS][COLS];
        this.grid = grid;
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Set<Set<Pair<Integer, Integer>>> distinctIslands = new HashSet<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1 && !seen[r][c]) {
                    rowOrigin = r;
                    colOrigin = c;
                    currentIsland = new HashSet<>();
                    dfs(r, c);
                    distinctIslands.add(currentIsland);
                }
            }
        }
        return distinctIslands.size();
    }

    private void dfs(int r, int c) {
        if (!(r >= 0 && r < ROWS) 
            || !(c >= 0 && c < COLS) 
            || seen[r][c] 
            || grid[r][c] == 0) {
            return;
        }

        seen[r][c] = true;
        currentIsland.add(new Pair<>(r - rowOrigin, c - colOrigin));
        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1]);
        }
    }
}
