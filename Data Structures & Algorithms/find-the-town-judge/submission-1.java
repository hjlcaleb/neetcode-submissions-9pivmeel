class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDeg = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] relationship : trust) {
            adj.get(relationship[0]).add(relationship[1]);
            inDeg[relationship[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (adj.get(i).isEmpty() && inDeg[i] == (n - 1)) return i;
        }

        return -1;
    }
}