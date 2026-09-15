class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] deg = new int[n + 1];
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            deg[u]++;
            deg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 1) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int neighbor : adj.get(cur)) {
                deg[neighbor]--;
                if (deg[neighbor] == 1) q.add(neighbor);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (deg[u] == 2 && deg[v] == 2) {
                return edges[i];
            }
        }
        
        return new int[2];
    }
}
