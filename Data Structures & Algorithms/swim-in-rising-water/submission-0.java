class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        q.add(new int[]{0, 0, grid[0][0]});

        boolean[][] visited = new boolean[n][m];
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];
            if (x == n - 1 && y == m - 1) return t;
            visited[x][y] = true;
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)
                    && !visited[nx][ny]) {
                    
                    q.add(new int[]{nx, ny, Math.max(grid[nx][ny], t)});
                }
            }
        }

        return -1;
    }
}
