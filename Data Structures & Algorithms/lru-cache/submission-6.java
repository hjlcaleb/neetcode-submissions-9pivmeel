class LRUCache {
    class Node {
        public Node prev;
        public Node next;
        public int key;
        public int val;
        public Node(int key, int val) {
            prev = null;
            next = null;
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void insert(Node node) {
        Node prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node retrieval = cache.get(key);
        remove(retrieval);
        insert(retrieval);
        return retrieval.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            Node lru = this.head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
