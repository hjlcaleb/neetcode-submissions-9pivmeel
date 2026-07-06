class Solution {
    public int minKnightMoves(int x, int y) {
        int count = 0;
        int[][] directions = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, 
            {-2, -1}, {-2, 1}, {-1, 2}};
        Set<Pair<Integer, Integer>> seen = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.remove();
                if (cur[0] == x && cur[1] == y) return count;
                for (int[] dir : directions) {
                    if (!seen.contains(new Pair<>(cur[0] + dir[0], cur[1] + dir[1]))) {
                        seen.add(new Pair<>(cur[0] + dir[0], cur[1] + dir[1]));
                        q.add(new int[]{cur[0] + dir[0], cur[1] + dir[1]});
                    }
                }
            }
            count++;
        }
        return count;
    }
}
