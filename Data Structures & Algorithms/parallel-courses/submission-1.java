class Solution {
    int[] visited;
    List<List<Integer>> adj;
    public int minimumSemesters(int n, int[][] relations) {
        adj = new ArrayList<>();
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] rel : relations) {
            adj.get(rel[0]).add(rel[1]);
        }

        int maxLength = 1;
        for (int node = 1; node < n + 1; node++) {
            int length = dfs(node);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
        
    }

    private int dfs(int course) {
        if (visited[course] == -1) {
            return -1;
        } else if (visited[course] != 0) {
            return visited[course];
        }

        visited[course] = -1;
        int maxLength = 1;
        for (int neighbor : adj.get(course)) {
            int length = dfs(neighbor);
            if (length == -1) {
                return -1;
            }
            maxLength = Math.max(length + 1, maxLength);
        }
        visited[course] = maxLength;
        return maxLength;
    }
}
