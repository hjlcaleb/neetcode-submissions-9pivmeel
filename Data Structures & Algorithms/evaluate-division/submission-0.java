class Solution {
    private Map<String, List<String[]>> adj;
    private Set<String> visited;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        adj = new HashMap<>();
        visited = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            adj.computeIfAbsent(equation.get(0), k -> new ArrayList<>()).add(new String[]{equation.get(1), 
                values[i] + ""});
            adj.computeIfAbsent(equation.get(1), k -> new ArrayList<>()).add(new String[]{equation.get(0), 
                (1 / values[i]) + ""});
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (adj.containsKey(query.get(0)) && adj.containsKey(query.get(1))) {
                result[i] = dfs(1, query.get(0), query.get(1));
                visited.clear();
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    private double dfs(double quo, String cur, String target) {
        if (cur.equals(target)) {
            return quo;
        }

        visited.add(cur);

        for (String[] neighbor : adj.get(cur)) {
            if (!visited.contains(neighbor[0])) {
                double res = dfs(Double.parseDouble(neighbor[1]) * quo, neighbor[0], target);
                if (res != -1) return res;
            }
        }
        return -1;
    }
}