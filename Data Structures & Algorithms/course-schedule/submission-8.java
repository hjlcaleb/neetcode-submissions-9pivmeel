class Solution {
    private int[] processed; // 0 = not visited, 1 = current, 2 = visited
    private Map<Integer, List<Integer>> adj; 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        processed = new int[numCourses];
        adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (processed[i] == 0) {
                if (!dfs(i)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (processed[course] == 2) {
            return true;
        }

        if (processed[course] == 1) {
            return false;
        }

        processed[course] = 1;
        for (int neighbor : adj.get(course)) {
            if (!dfs(neighbor)) return false;
        }
        processed[course] = 2;
        return true;
    }
}
