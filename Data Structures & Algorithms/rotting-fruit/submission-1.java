class Solution {
    public int orangesRotting(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            minutes++;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] fruit = q.remove();
                for (int[] dir : directions) {
                    if (fruit[0] + dir[0] >= 0 && fruit[0] + dir[0] < N
                        && fruit[1] + dir[1] >= 0 && fruit[1] + dir[1] < M 
                        && grid[fruit[0] + dir[0]][fruit[1] + dir[1]] == 1) {

                        q.add(new int[] {fruit[0] + dir[0], fruit[1] + dir[1]}); 
                        grid[fruit[0] + dir[0]][fruit[1] + dir[1]] = 2;
                        fresh--;
                    }
                }
            }
        }

        if (fresh > 0) return -1;
        
        return minutes;
    }
}
