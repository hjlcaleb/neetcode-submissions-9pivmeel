class LRUCache {
    
    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        
        public Node(int key, int val) {
            prev = null;
            next = null;
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node least;
    private Node most;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        least = new Node(-1, -1);
        most = new Node(-1, -1);
        least.next = most;
        most.prev = least;
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
            Node retrieval = cache.get(key);
            remove(retrieval);
            insert(retrieval);
            return retrieval.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node update = cache.get(key);
            update.val = value;
            remove(update);
            insert(update);
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
