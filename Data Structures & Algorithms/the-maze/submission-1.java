class Solution {
    private int[][] maze;
    private int[] destination;
    private int[][] directions;
    private boolean[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.destination = destination;
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited = new boolean[maze.length][maze[0].length];

        return dfs(start);
    }

    private boolean dfs(int[] current) {
        if (current[0] == destination[0] && current[1] == destination[1]) {
            return true;
        }

        if (visited[current[0]][current[1]]) return false;

        visited[current[0]][current[1]] = true;
        
        for (int[] d : directions) {
            int row = current[0];
            int col = current[1];
            while (row + d[0] >= 0 && row + d[0] < maze.length &&
                   col + d[1] >= 0 && col + d[1] < maze[0].length &&
                   maze[row + d[0]][col + d[1]] == 0) {
                row += d[0];
                col += d[1];
            }
            if (dfs(new int[]{row, col})) return true;
        }
        return false;
    }
}
