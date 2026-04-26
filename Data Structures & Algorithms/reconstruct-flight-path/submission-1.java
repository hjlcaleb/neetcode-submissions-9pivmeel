class Solution {
    private List<String> result;
    private List<List<String>> tickets;
    private Map<String, PriorityQueue<String>> adj;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        this.tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        adj = new HashMap<>();
        for (List<String> airport : this.tickets) {
            adj.computeIfAbsent(airport.get(0), k -> new PriorityQueue<>()).add(airport.get(1));
        }
        
        result = new ArrayList<>();
        dfs("JFK");
        return result;
    }

    private void dfs(String src) {
        PriorityQueue<String> minHeap = adj.get(src);

        while (minHeap != null && !minHeap.isEmpty()) {
            String neighbor = minHeap.remove();
            dfs(neighbor);
        }

        result.add(0, src);
    }
}
