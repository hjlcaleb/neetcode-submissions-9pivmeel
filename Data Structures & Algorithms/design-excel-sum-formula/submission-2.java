class Excel {
    private Map<String, Integer> values; // cell -> value
    private Map<String, List<String>> formulas; // cell -> map(formula cell -> count)
    private Map<String, Set<String>> dependents; // cell -> all cells dependent on it


    public Excel(int height, char width) {
        values = new HashMap<>();
        formulas = new HashMap<>();
        dependents = new HashMap<>();
    }
    
    public void set(int row, char column, int val) {
        String cell = getCell(row, column);

        // 1. remove this cell from the formulas of the dependent cells
        clearDependents(cell);
        formulas.remove(cell);

        // 2. update value of the cell
        values.put(cell, val);

        // 3. recompute dependent cell formulas
        recompute(cell);
    }
    
    public int get(int row, char column) {
        String cell = getCell(row, column);
        return values.getOrDefault(cell, 0);
    }
    
    public int sum(int row, char column, String[] numbers) {
        String cell = getCell(row, column);

        // 1. remove this cell from the formulas of the dependent cells
        clearDependents(cell);

        // 2. add new formula, update dependencies
        List<String> components = new ArrayList<>();
        for (String range : numbers) {
            if (!range.contains(":")) {
                components.add(range);
            } else {
                String[] parts = range.split(":");
                int r1 = Integer.parseInt(parts[0].substring(1));
                char c1 = parts[0].charAt(0);
                int r2 = Integer.parseInt(parts[1].substring(1));
                char c2 = parts[1].charAt(0);

                for (int r = r1; r <= r2; r++) {
                    for (char c = c1; c <= c2; c++) {
                        String addCell = getCell(r, c);
                        components.add(addCell);
                    }
                }
            }
        }

        formulas.put(cell, components);

        for (String source : components) {
            dependents.computeIfAbsent(source, k -> new HashSet<>()).add(cell);
        }

        recompute(cell);
        return values.get(cell);
    }

    private String getCell(int row, char column) {
        return column + "" + row;
    }

    // removes cell from the formulas of the dependent cells
    // cells contained in previous formula no longer depend on this cell
    private void clearDependents(String cell) { 
        if (formulas.containsKey(cell)) {
            for (String dep : formulas.get(cell)) {
                if (dependents.containsKey(dep)) {
                    dependents.get(dep).remove(cell);
                }
            }
        }   
        
    }

    // recomputes the values of all the dependent cells
    private void recompute(String cell) {
        if (formulas.containsKey(cell)) {
            int sum = 0;
            for (String component : formulas.get(cell)) {
                sum += values.getOrDefault(component, 0);
            }
            values.put(cell, sum);
        }

        if (dependents.containsKey(cell)) {
            for (String dep : dependents.get(cell)) {
                recompute(dep);
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
