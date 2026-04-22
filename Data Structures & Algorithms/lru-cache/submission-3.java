class LRUCache {
    
    private class Node {
        public Node prev;
        public Node next;
        private int key;
        public int val;

        public Node(int key, int val) {
            prev = null;
            next = null;
            this.key = key;
            this.val = val;
        }
    }

    private Node least;
    private Node most;
    private int capacity;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        least = new Node(-1, -1);
        most = new Node(-1, -1);
        least.next = most;
        most.prev = least;
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    private void insert(Node node) {
        Node mru = most.prev;
        mru.next = node;
        node.prev = mru;
        node.next = most;
        most.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node retrievedNode = cache.get(key);
            remove(retrievedNode);
            insert(retrievedNode);
            return retrievedNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node updateNode = cache.get(key);
            updateNode.val = value;
            remove(updateNode);
            insert(updateNode);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);
        }

        if (cache.size() > capacity) {
            Node lru = least.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
