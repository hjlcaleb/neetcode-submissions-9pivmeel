class FileSystem {
    private class Dir {
        public Map<String, Dir> subdirs;
        public String content;

        public Dir() {
            subdirs = new TreeMap<>();
            content = null;
        }
    }
    
    private Dir root;
    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir curNode = root;
        if (!path.equals("/")) {
            String[] components = path.split("/");
            String curString;
            for (int i = 1; i < components.length; i++) { // k number of components in the path
                curString = components[i];
                curNode = curNode.subdirs.get(curString);
                if (i == components.length - 1 && curNode.content != null) {
                    return Arrays.asList(curString);
                }
            }
        }

        List<String> children = new ArrayList<>(curNode.subdirs.keySet());
        // Collections.sort(children); // m log(m)
        return children;
    }
    
    public void mkdir(String path) {
        Dir curNode = root;
        String[] components = path.split("/");
        for (int i = 1; i < components.length; i++) {
            String curString = components[i];
            if (!curNode.subdirs.containsKey(curString)) {
                curNode.subdirs.put(curString, new Dir());
            }
            curNode = curNode.subdirs.get(curString);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir curNode = root;
        String[] components = filePath.split("/");
        for (int i = 1; i < components.length; i++) {
            String curString = components[i];
            if (!curNode.subdirs.containsKey(curString)) {
                curNode.subdirs.put(curString, new Dir());
            }
            curNode = curNode.subdirs.get(curString);
        }

        if (curNode.content != null) {
            curNode.content += content;
        } else {
            curNode.content = content;
        }
    }
    
    public String readContentFromFile(String filePath) {
        Dir curNode = root;
        String[] components = filePath.split("/");
        for (int i = 1; i < components.length; i++) {
            String curString = components[i];
            if (!curNode.subdirs.containsKey(curString)) {
                curNode.subdirs.put(curString, new Dir());
            }
            curNode = curNode.subdirs.get(curString);
        }

        return curNode.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
