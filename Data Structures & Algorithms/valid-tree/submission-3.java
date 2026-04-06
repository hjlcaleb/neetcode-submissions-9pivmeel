class Solution {
    private Map<Integer, List<Integer>> adjList;
    private Set<Integer> visited;

    public boolean validTree(int n, int[][] edges) {
        adjList = new HashMap<>();
        visited = new HashSet<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        if (isAcyclic(0, -1)) {
            return visited.size() == n;
        }
        return false;
    }

    private boolean isAcyclic(int node, int pred) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (neighbor != pred) {
                if (!isAcyclic(neighbor, node)) return false;
            }
        }

        return true;
    }
}
