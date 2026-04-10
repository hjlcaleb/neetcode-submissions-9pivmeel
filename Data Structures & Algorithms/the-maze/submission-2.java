class Solution {
    private boolean[][] visited;
    private int[][] maze;
    private int N;
    private int M;
    private int[][] directions;
    private int[] destination;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        N = maze.length;
        M = maze[0].length;
        visited = new boolean[N][M];
        this.directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        this.destination = destination;
        return dfs(start[0], start[1]);
    }

    private boolean dfs(int r, int c) {
        if (r == destination[0] && c == destination[1]) {
            return true;
        }

        if (visited[r][c]) {
            return false;
        }

        visited[r][c] = true;
        
        for (int[] dir : directions) {
            int nr = r;
            int nc = c;
            while ((nr + dir[0] >= 0 && nr + dir[0] < N) && 
                    (nc + dir[1] >= 0 && nc + dir[1] < M) && 
                    maze[nr + dir[0]][nc + dir[1]] == 0) {
                nr += dir[0];
                nc += dir[1];
            }
            if (dfs(nr, nc)) return true;
        }

        return false;
    }
}
