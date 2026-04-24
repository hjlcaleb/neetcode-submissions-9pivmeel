class Solution {
    private int N;
    private int M;
    private int[][] grid;
    private int MAX_VALUE = 100000000;
    private int[][] cache;

    public int minPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        this.grid = grid;
        cache = new int[M][N];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int r, int c) {
        if (outOfBounds(r, c)) return MAX_VALUE;
        if (r == M - 1 && c == N - 1) return grid[r][c];
        if (cache[r][c] != -1) return cache[r][c];
         
        int leftPath = grid[r][c] + dfs(r, c + 1);
        int downPath = grid[r][c] + dfs(r + 1, c);
        cache[r][c] = Math.min(leftPath, downPath);
        return cache[r][c];
    }

    private boolean outOfBounds(int r, int c) {
        return !(r >= 0 && r < M) || !(c >= 0 && c < N);
    }
}