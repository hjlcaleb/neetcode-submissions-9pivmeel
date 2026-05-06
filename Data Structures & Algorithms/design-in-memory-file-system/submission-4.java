class FileSystem {

    public class Entry {
        private String content;
        private Map<String, Entry> children;
        public Entry() {
            content = null;
            children = new TreeMap<>();
        }
    }

    private Entry root;

    public FileSystem() {
        root = new Entry();
    }
    
    public List<String> ls(String path) {
        Entry cur = root;
        String[] components = path.split("/");
        for (int i = 1; i < components.length; i++) {
            String curComponent = components[i];
            if (!cur.children.containsKey(curComponent)) {
                cur.children.put(curComponent, new Entry());
            }

            cur = cur.children.get(curComponent);
            if (i == components.length -1 && cur.content != null) {
                return Arrays.asList(curComponent);
            }
        }

        List<String> children = new ArrayList<>(cur.children.keySet());
        return children;
    }
    
    public void mkdir(String path) {
        Entry cur = root;
        String[] components = path.split("/");
        for (int i = 1; i < components.length; i++) {
            String curComponent = components[i];
            if (!cur.children.containsKey(curComponent)) {
                cur.children.put(curComponent, new Entry());
            }
            cur = cur.children.get(curComponent);   
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Entry cur = root;
        String[] components = filePath.split("/");
        for (int i = 1; i < components.length; i++) {
            String curComponent = components[i];
            if (!cur.children.containsKey(curComponent)) {
                cur.children.put(curComponent, new Entry());
            }
            cur = cur.children.get(curComponent);   
        }
        if (cur.content != null) {
            cur.content += content;
        } else {
            cur.content = content;
        }
    }
    
    public String readContentFromFile(String filePath) {
        Entry cur = root;
        String[] components = filePath.split("/");
        for (int i = 1; i < components.length; i++) {
            String curComponent = components[i];
            if (!cur.children.containsKey(curComponent)) {
                cur.children.put(curComponent, new Entry());
            }
            cur = cur.children.get(curComponent);   
        }
        return cur.content;
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
