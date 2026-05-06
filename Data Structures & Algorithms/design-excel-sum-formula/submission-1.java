class Excel {
    private Map<String, Integer> values; // key -> computed value
    private Map<String, List<String>> formulas; // key -> list of dependency keys (a formula)
    private Map<String, Set<String>> dependents; // key -> set of keys that depend on it
    
    public Excel(int height, char width) {
        values = new HashMap<>();
        formulas = new HashMap<>();
        dependents = new HashMap<>();    
    }
    
    public void set(int row, char column, int val) {
        String key = getKey(row, column);
        clearDependencies(key);
        values.put(key, val);
        formulas.remove(key);
        recompute(key);
    }
    
    public int get(int row, char column) {
        String key = getKey(row, column);
        return values.getOrDefault(key, 0);
    }
    
    public int sum(int row, char column, String[] numbers) {
        String key = getKey(row, column);
        clearDependencies(key);
        List<String> deps = new ArrayList<>();

        // parse formula
        for (String s : numbers) {
            if (!s.contains(":")) {    
                deps.add(s);
                formulas.put(key, new ArrayList<>(Arrays.asList(s)));
            } else {
                String[] components = s.split(":");
                int r1 = Integer.parseInt(components[0].substring(1));
                int r2 = Integer.parseInt(components[1].substring(1));
                char c1 = components[0].charAt(0);
                char c2 = components[1].charAt(0);

                for (int r = r1; r <= r2; r++) {
                    for (char c = c1; c <= c2; c++) {
                        deps.add(getKey(r, c));
                    }
                }
            }
        }
        formulas.put(key, deps);
        for (String depKey : deps) {
            dependents.computeIfAbsent(depKey, k -> new HashSet<>()).add(key);
        }
        recompute(key);
        return get(row, column);
    }

    private String getKey(int row, char column) {
        return column + "" + row;
    }

    // clears the old dependencies
    // wiping the formula. 
    // cells contained in previous formula no longer depend on this cell
    private void clearDependencies(String key) {
        if (formulas.containsKey(key)) {
            for (String depKey : formulas.get(key)) {
                if (dependents.containsKey(depKey)) {
                    dependents.get(depKey).remove(key);
                }
            }
        }
    }

    private void recompute(String key) {
        if (formulas.containsKey(key)) {
            int sum = 0;
            for (String depKey : formulas.get(key)) {
                sum += values.getOrDefault(depKey, 0);
            }
            values.put(key, sum);
        }

        if (dependents.containsKey(key)) {
            for (String dependentKey : dependents.get(key)) {
                recompute(dependentKey);
            }
        }
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
