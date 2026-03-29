class NumMatrix {
    private int[][] prefixSums;
    public NumMatrix(int[][] matrix) {
        int ROWS = matrix.length; 
        int COLS = matrix[0].length;
        prefixSums = new int[ROWS + 1][COLS + 1];
        for (int r = 0; r < ROWS; r++) {
            int prefix = 0;
            for (int c = 0; c < COLS; c++) {
                prefix += matrix[r][c];
                int above = prefixSums[r][c + 1];
                prefixSums[r + 1][c + 1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1 + 1;
        int r2 = row2 + 1;
        int c1 = col1 + 1;
        int c2 = col2 + 1;
        
        int bottomRight = prefixSums[r2][c2];
        int above = prefixSums[r1 - 1][c2];
        int left = prefixSums[r2][c1 - 1];
        int topLeft = prefixSums[r1 - 1][c1 - 1];

        return bottomRight - above - left + topLeft;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */