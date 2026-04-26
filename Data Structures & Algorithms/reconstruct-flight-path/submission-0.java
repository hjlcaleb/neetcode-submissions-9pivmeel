class Solution {
    private List<String> result;
    private List<List<String>> tickets;
    private Map<String, List<String>> adj;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        this.tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        adj = new HashMap<>();
        for (List<String> airport : this.tickets) {
            adj.putIfAbsent(airport.get(0), new ArrayList<>());
            adj.get(airport.get(0)).add(airport.get(1));
        }
        
        result = new ArrayList<>();
        result.add("JFK");
        if (dfs("JFK")) {
            return result;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String source) {
        if (result.size() == tickets.size() + 1) return true;
        if (!adj.containsKey(source)) return false;

        List<String> neighbors = new ArrayList<>(adj.get(source));
        for (int i = 0; i < neighbors.size(); i++) {
            String v = neighbors.get(i);
            adj.get(source).remove(i);
            result.add(v);
            if (dfs(v)) return true;
            adj.get(source).add(i, v);
            result.remove(result.size() - 1);
        }
        return false;
    }
}
