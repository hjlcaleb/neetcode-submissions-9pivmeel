class TicTacToe {
    private int n;
    private int[] rows;
    private int[] cols;
    private int posDiag; // bottom left to top right
    private int negDiag; // top left to bottom right
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        posDiag = 0;
        negDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        rows[row] += (player == 1) ? 1 : -1;
        cols[col] += (player == 1) ? 1 : -1;
        if (row + col == n - 1) {
            posDiag += (player == 1) ? 1 : -1;
        }

        if (row - col == 0) {
            negDiag += (player == 1) ? 1 : -1;
        }

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n 
            || Math.abs(posDiag) == n || Math.abs(negDiag) == n) {
            return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
