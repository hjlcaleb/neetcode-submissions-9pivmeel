class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) { 
            return -1; 
        }

        int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, 
                                {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int r = cell[0];
            int c = cell[1];
            int length = cell[2];

            if (r == n - 1 && c == n - 1) return length;

            for (int[] d : directions) {
                int newR = r + d[0];
                int newC = c + d[1];
                if (newR >= 0 && newC >= 0 &&
                    newR < n && newC < n &&
                    grid[newR][newC] == 0 &&
                    !visit[newR][newC]) {
                    visit[newR][newC] = true;
                    queue.add(new int[]{newR, newC, length + 1});
                }
            }
        }
        return -1;
    }
}