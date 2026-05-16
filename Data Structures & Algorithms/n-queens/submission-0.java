class Solution {
    private int n;
    private Set<Integer> col;
    private Set<Integer> posDiag;
    private Set<Integer> negDiag;
    private char[][] board;
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        board = new char[n][n];
        result = new ArrayList<>();
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0);
        return result;
    }

    private void backtrack(int r) {
        if (r == n) {
            List<String> sequence = new ArrayList<>();
            for (char[] row : board) {
                sequence.add(String.valueOf(row));
            }
            result.add(sequence);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';
            
            backtrack(r + 1);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }



    }
}
