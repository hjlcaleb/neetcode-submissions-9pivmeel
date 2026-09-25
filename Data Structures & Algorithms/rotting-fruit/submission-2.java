class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int freshFruit = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) freshFruit++;
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
            }
        }

        int minutes = 0;
        while (!q.isEmpty() && freshFruit > 0) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.remove();
                for (int[] dir : directions) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if (nr >= 0 && nr < grid.length &&
                        nc >= 0 && nc < grid[0].length &&
                        grid[nr][nc] == 1) {

                        freshFruit--;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});        
                    }
                }
            }
            minutes++;
        }

        return (freshFruit == 0) ? minutes : -1;
    }
}
