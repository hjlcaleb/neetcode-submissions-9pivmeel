class Solution {
    private int m;
    private int n;
    private int[][] cache;
    private int maxSide;
    private char[][] matrix;
    public int maximalSquare(char[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        cache = new int[m + 1][n + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        maxSide = 0;
        this.matrix = matrix;
        dfs(0, 0);
        return maxSide * maxSide;
    }

    private int dfs(int r, int c) {
        if (r >= m || c >= n) return 0;

        if (cache[r][c] != -1) return cache[r][c];
        int down = dfs(r + 1, c);
        int right = dfs(r, c + 1);
        int diag = dfs(r + 1, c + 1);
        if (matrix[r][c] == '1') {
            cache[r][c] = 1 + Math.min(Math.min(down, right), diag);
            maxSide = Math.max(maxSide, cache[r][c]);
        } else {
            cache[r][c] = 0;
        }
        
        return cache[r][c];
    }
}