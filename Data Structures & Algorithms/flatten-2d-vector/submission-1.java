class Vector2D {
    private int row;
    private int col;
    private int[][] data;

    public Vector2D(int[][] vec) {
        row = 0;
        col = 0;
        data = vec;
    }

    public int next() {
        hasNext();
        return data[row][col++];
    }

    public boolean hasNext() {
        while (row < data.length && col == data[row].length) {
            row++;
            col = 0;
        }
        return row < data.length;
    }
}
