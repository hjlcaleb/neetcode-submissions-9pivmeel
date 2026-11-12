class Vector2D {
    private Queue<Integer> queue;

    public Vector2D(int[][] vec) {
        queue = new LinkedList<>();
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                queue.add(vec[i][j]);
            }
        }
    }
    public int next() { return queue.remove(); }
    public boolean hasNext() { return !queue.isEmpty(); }
}
