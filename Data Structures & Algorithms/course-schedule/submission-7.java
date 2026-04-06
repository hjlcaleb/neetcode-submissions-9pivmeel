class Solution {
    private Map<Integer, List<Integer>> adjList; 
    private Set<Integer> visited;
    private Set<Integer> visiting;

    public boolean canFinish(int numCourses, int[][] prerequisites) {        
        adjList = new HashMap<>();
        visited = new HashSet<>();
        visiting = new HashSet<>();
        for (int[] prereq : prerequisites) {
            adjList.computeIfAbsent(prereq[1], k -> new ArrayList<>()).add(prereq[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int currentCourse) {
        if (visiting.contains(currentCourse)) {
            return false;
        }

        if (visited.contains(currentCourse)) {
            return true;
        }

        visiting.add(currentCourse);

        for (int course : adjList.getOrDefault(currentCourse, new ArrayList<>())) {
            if (!dfs(course)) return false;
        }

        visiting.remove(currentCourse);

        visited.add(currentCourse);

        return true;
    }
}
