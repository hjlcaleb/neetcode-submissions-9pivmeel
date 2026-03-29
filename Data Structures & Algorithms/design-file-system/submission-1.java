class FileSystem {
    private Map<String, Integer> pathToValue;
    public FileSystem() {
        pathToValue = new HashMap<>();
        pathToValue.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        // path already exists
        if (pathToValue.containsKey(path)) {
            return false;
        }
        // determine if parent path exists
        int lastSlash = path.lastIndexOf("/");
        String parentPath = path.substring(0, lastSlash);
        if (!pathToValue.containsKey(parentPath)) {
            return false;
        }
        pathToValue.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if (!pathToValue.containsKey(path)) {
            return -1;
        }
        return pathToValue.get(path);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
