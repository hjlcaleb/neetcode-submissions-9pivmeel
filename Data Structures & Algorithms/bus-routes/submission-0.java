class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Map<Integer, List<Integer>> stopsToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                stopsToBuses.computeIfAbsent(routes[i][j], k -> new ArrayList<>()).add(i);
            }
        }

        int numBuses = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visitedStops.add(source);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int curStop = q.remove();
                if (curStop == target) return numBuses;
                for (int bus : stopsToBuses.getOrDefault(curStop, new ArrayList<>())) {
                    if (!visitedBuses.contains(bus)) {
                        for (int stop : routes[bus]) {
                            if (!visitedStops.contains(stop)) {
                                q.add(stop);
                                visitedStops.add(stop);
                            }
                        }
                        visitedBuses.add(bus);
                    }
                }
            }
            numBuses++;
        }
        return -1;
    }
}