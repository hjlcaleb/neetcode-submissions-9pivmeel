class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            inDeg[prereq[0]]++;
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) { 
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.remove();
            res.add(course);
            for (int neighbor : adj.get(course)) {
                inDeg[neighbor]--;
                if (inDeg[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (res.size() != numCourses) return new int[0];
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
