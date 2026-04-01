class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROW = board.length;
        int COL = board[0].length;

        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<String, Set<Integer>> boxMap = new HashMap<>();

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                int cell = board[r][c];
                if (cell != '.') {
                    if (!rowMap.computeIfAbsent(r, k -> new HashSet<>()).add(cell)
                        || !colMap.computeIfAbsent(c, k -> new HashSet<>()).add(cell)
                        || !boxMap.computeIfAbsent(r / 3 + "," + c / 3, k -> new HashSet<>()).add(cell)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
