class Solution {
    private List<Integer> result;
    private Map<Integer, List<Integer>> adj;
    private Set<Integer> currPath;
    private Set<Integer> visited;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new ArrayList<>();
        adj = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
        }

        currPath = new HashSet<>();
        visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return new int[0];
        }

        if (result.size() != numCourses) {
            return new int[0];
        }

        int[] ordering = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ordering[i] = result.get(i);
        }
        return ordering;
    }

    private boolean dfs(int curCourse) {
        if (currPath.contains(curCourse)) {
            return false;
        }

        if (visited.contains(curCourse)) {
            return true;
        }
        
        currPath.add(curCourse);
        
        for (int course : adj.get(curCourse)) {
            if (!dfs(course)) {
                return false;
            }
        }

        currPath.remove(curCourse);
        visited.add(curCourse);
        result.add(0, curCourse);
        return true;
    }
}
