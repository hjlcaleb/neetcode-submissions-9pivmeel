class Solution {
    private int numComponents;
    private Map<Integer, List<Integer>> adj;
    private Set<Integer> seen;

    public int countComponents(int n, int[][] edges) {
        numComponents = 0;
        adj = new HashMap<>();
        seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                dfs(i);
                numComponents++;
            }
        }

        return numComponents;

    }

    private void dfs(int node) {
        if (seen.contains(node)) {
            return;
        }
        
        seen.add(node);

        for (int neighbor : adj.get(node)) {
            dfs(neighbor);
        }
    }
}
