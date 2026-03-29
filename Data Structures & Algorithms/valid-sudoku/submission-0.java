class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int i = 0; i < 9; i++){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
        }

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                String squarePair = (r/3) + "," + (c/3);
                
                squares.putIfAbsent(squarePair, new HashSet<>());
                                
                if(board[r][c] != '.'){
                    if(rows.get(r).contains(board[r][c]) 
                    || cols.get(c).contains(board[r][c])
                    || squares.get(squarePair).contains(board[r][c])){
                        return false;
                    }

                    rows.get(r).add(board[r][c]);
                    cols.get(c).add(board[r][c]);
                    squares.get(squarePair).add(board[r][c]);

                }
            }
        }

        return true;

    }

}
