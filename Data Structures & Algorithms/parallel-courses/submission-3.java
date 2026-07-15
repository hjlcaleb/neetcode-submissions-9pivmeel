class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDeg = new int[n + 1];
        for (int[] rel : relations) {
            adj.computeIfAbsent(rel[0], k -> new ArrayList<>()).add(rel[1]);
            inDeg[rel[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) q.add(i);
        }
        
        int numSemesters = 0;
        int completedCourses = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int curCourse = q.remove();
                completedCourses++;
                for (int nextCourse : adj.getOrDefault(curCourse, new ArrayList<>())) {
                    inDeg[nextCourse]--;
                    if (inDeg[nextCourse] == 0) {
                        q.add(nextCourse);
                    }
                }
            }
            numSemesters++;
        }
        return (completedCourses == n) ? numSemesters : -1;
    }
}
