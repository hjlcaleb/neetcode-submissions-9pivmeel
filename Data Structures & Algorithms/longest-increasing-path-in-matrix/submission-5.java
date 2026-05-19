class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] inDeg = new int[matrix.length][matrix[0].length];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int[] dir : directions) {
                    int newI = i + dir[0];
                    int newJ = j + dir[1];
                    if (newI >= 0 && newI < matrix.length
                        && newJ >= 0 && newJ < matrix[0].length
                        && matrix[newI][newJ] < matrix[i][j]) {
                        
                        inDeg[i][j]++;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (inDeg[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int lip = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.remove();
                for (int[] dir : directions) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if (ni >= 0 && ni < matrix.length
                        && nj >= 0 && nj < matrix[0].length
                        && matrix[ni][nj] > matrix[cur[0]][cur[1]]) {
                        
                        inDeg[ni][nj]--;
                        if (inDeg[ni][nj] == 0) {
                            q.add(new int[]{ni, nj});
                        }
                    }
                }
            }
            lip++;
        }
        return lip;
    }
}
