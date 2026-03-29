class Solution {
    public boolean isValidSudoku(char[][] board) {
        int NUM_ROWS = board.length;
        int NUM_COLS = NUM_ROWS;

        Set<Character> rowNums = new HashSet<>();
        Set<Character> colNums = new HashSet<>();
        Map<Integer, HashSet<Character>> squareNums = new HashMap<>();

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                if (board[i][j] != '.') {
                    if (rowNums.contains(board[i][j])) {
                        return false;
                    } else {
                        rowNums.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (colNums.contains(board[j][i])) {
                        return false;
                    } else {
                        colNums.add(board[j][i]);
                    }
                }
                if (board[i][j] != '.') {
                    int boxId = i/3 * 3 + j/3;
                    if (squareNums.get(boxId) != null && 
                        squareNums.get(boxId).contains(board[i][j])) {
                        return false;
                    }
                    squareNums.putIfAbsent(boxId, new HashSet<>());
                    squareNums.get(boxId).add(board[i][j]);
                }
            }
            rowNums.clear();
            colNums.clear();
        }
        return true;
    }
}
