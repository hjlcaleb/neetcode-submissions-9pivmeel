class Solution {
    private int N;
    private int M;
    private int[][] directions;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        N = heights.length;
        M = heights[0].length;
        boolean[][] pac = new boolean[N][M];
        boolean[][] atl = new boolean[N][M];
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        this.heights = heights;

        for (int c = 0; c < M; c++) {
            dfs(0, c, -1, pac);
            dfs(N -1, c, -1, atl);
        }

        for (int r = 0; r < N; r++) {
            dfs(r, 0, -1, pac);
            dfs(r, M - 1, -1, atl);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(new ArrayList<>(Arrays.asList(r, c)));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, int prevHeight, boolean[][] ocean) {
        if (!(r >= 0 && r < N) || !(c >= 0 && c < M) || 
            heights[r][c] < prevHeight || ocean[r][c]) {
            return;
        }

        ocean[r][c] = true;
        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], heights[r][c], ocean);
        }
    }
}
