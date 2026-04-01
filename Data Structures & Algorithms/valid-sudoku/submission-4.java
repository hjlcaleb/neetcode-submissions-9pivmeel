class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROW = board.length;
        int COL = board[0].length;
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board[r][c] == '.') continue;
                if (!seen.add(board[r][c] + " in row " + r) 
                    || !seen.add(board[r][c] + " in col " + c)
                    || !seen.add(board[r][c] + " in box " + r / 3 + ", " + c / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}
