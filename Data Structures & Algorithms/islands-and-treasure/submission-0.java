class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int M = grid.length;
        int N = grid[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[] {r, c});
                }
            }
        }
        
        int distance = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            distance++;
            for (int i = 0; i < qSize; i++) {
                int[] treasure = q.remove();
                for (int[] dir : directions) {
                    int newR = treasure[0] + dir[0];
                    int newC = treasure[1] + dir[1];
                    if (newR >= 0 && newR < M
                        && newC >= 0 && newC < N &&
                        grid[newR][newC] == Integer.MAX_VALUE) {
                        q.add(new int[]{newR, newC});
                        grid[newR][newC] = distance;
                    }
                }
            }
        }
    }
}
