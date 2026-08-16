class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<String, Set<Integer>> squares = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!rows.computeIfAbsent(i, k -> new HashSet<>()).add(board[i][j] - '0')) {
                        return false;
                    }

                    if (!cols.computeIfAbsent(j, k -> new HashSet<>()).add(board[i][j] - '0')) {
                        return false;
                    }
                    
                    if (!squares.computeIfAbsent(i / 3 + "," + j / 3, 
                        k -> new HashSet<>()).add(board[i][j] - '0')) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
