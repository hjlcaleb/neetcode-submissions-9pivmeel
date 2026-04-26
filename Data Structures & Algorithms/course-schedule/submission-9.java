class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            inDeg[prereq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        int processed = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int curCourse = q.remove();
                processed++;
                for (int neighbor : adj.get(curCourse)) {
                    inDeg[neighbor]--;
                    if (inDeg[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        return processed == numCourses;
    }
}
