class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] rel : relations) {
            inDegree[rel[1]] ++;
            adj.get(rel[0]).add(rel[1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int numSemesters = 0;
        int coursesProcessed = 0;
        
        while (!q.isEmpty()) {
            numSemesters++;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int course = q.remove();
                coursesProcessed++;
                for (int dependentCourse : adj.get(course)) {
                    inDegree[dependentCourse] --;
                    if (inDegree[dependentCourse] == 0) {
                        q.add(dependentCourse);
                    }
                }
            }
        }

        if (coursesProcessed < n) {
            return -1;
        }

        return numSemesters;
    }
}
