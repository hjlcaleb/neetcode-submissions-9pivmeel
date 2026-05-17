class Solution {
    private int n;
    private int m;
    private char[][] board;
    private int[][] directions;

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        this.board = board;
        this.directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c);
            }
            
            if (board[n - 1][c] == 'O') {
                dfs(n - 1, c);
            }
        }
        
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0);
            }
            
            if (board[r][m - 1] == 'O') {
                dfs(r, m - 1);
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
    

    private void dfs(int r, int c) {
        if (!(r >= 0 && r < n) || !(c >= 0 && c < m) || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';

        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1]);
        }
    }
}
