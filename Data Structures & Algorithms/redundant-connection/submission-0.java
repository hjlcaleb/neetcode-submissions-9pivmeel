class Solution {
    private Map<Integer, List<Integer>> adj;
    private boolean[] visited;
    private Set<Integer> cycle;
    private int start;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        visited = new boolean[n + 1];
        cycle = new HashSet<>();
        start = -1;
        dfs(1, -1);

        for (int i = n - 1; i >= 0; i--) {
            if (cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) {
                return edges[i];
            }
        }

        return new int[2];
    }

    private boolean dfs(int curNode, int prevNode) {
        if (visited[curNode]) {
            start = curNode;
            return true;
        }

        visited[curNode] = true;
        for (int neighbor : adj.get(curNode)) {
            if (neighbor == prevNode) continue;
            if (dfs(neighbor, curNode)) {
                if (start != -1) cycle.add(curNode);
                if (curNode == start) {
                    start = -1;
                    break;
                }
                return true;
            }
        }
        return false;
    }
}
