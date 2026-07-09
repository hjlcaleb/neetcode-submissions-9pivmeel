class TicTacToe {
    private int n;
    private int[] rows;
    private int[] cols;
    private Map<Integer, Integer> posDiag;
    private Map<Integer, Integer> negDiag;
    
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        posDiag = new HashMap<>();
        negDiag = new HashMap<>();    
    }
    
    public int move(int row, int col, int player) {
        if (player == 1) {
            rows[row]++;
            cols[col]++;
            posDiag.put(row + col, posDiag.getOrDefault(row + col, 0) + 1);
            negDiag.put(row - col, negDiag.getOrDefault(row - col, 0) + 1);
            if (rows[row] == n || cols[col] == n || posDiag.get(row + col) == n || 
                negDiag.get(row - col) == n) {
                return 1;
            }
        } else {
            rows[row]--;
            cols[col]--;
            posDiag.put(row + col, posDiag.getOrDefault(row + col, 0) - 1);
            negDiag.put(row - col, negDiag.getOrDefault(row - col, 0) - 1);
            if (rows[row] == -n || cols[col] == -n || posDiag.get(row + col) == -n || 
                negDiag.get(row - col) == -n) {
                return 2;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
