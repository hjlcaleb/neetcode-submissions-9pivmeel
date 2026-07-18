class LFUCache {
    class ListNode {
        public ListNode prev;
        public ListNode next;
        public int key;
        public int val;
        public int freq;

        public ListNode(int key, int val) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        private ListNode left, right;
        private int size;

        public DoublyLinkedList() {
            this.left = new ListNode(0, 0);
            this.right = new ListNode(0, 0);
            this.left.next = this.right;
            this.right.prev = this.left;
            this.size = 0;
        }

        public int length() {
            return size;
        }

        public void insertRight(ListNode node) {
            ListNode prev = this.right.prev;
            prev.next = node;
            node.prev = prev;
            node.next = this.right;
            this.right.prev = node;
            size++;
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }

        public ListNode popLeft() {
            ListNode node = this.left.next;
            remove(node);
            return node;
        }
    }

    private int capacity;
    private int lfuCount;
    private Map<Integer, ListNode> nodeMap; // key -> value
    private Map<Integer, DoublyLinkedList> listMap; // freq -> dll

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCount = 0;
        this.nodeMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }
    
    private void counter(ListNode node) {
        int count = node.freq;
        listMap.get(count).remove(node);

        if (count == lfuCount && listMap.get(count).length() == 0) {
            lfuCount++;
        }

        node.freq++;
        listMap.putIfAbsent(node.freq, new DoublyLinkedList());
        listMap.get(node.freq).insertRight(node);
        
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        ListNode node = nodeMap.get(key);
        counter(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            ListNode node = nodeMap.get(key);
            node.val = value;
            counter(node);
            return;
        }

        if (nodeMap.size() == capacity) {
            ListNode rmNode = listMap.get(lfuCount).popLeft();
            nodeMap.remove(rmNode.key);
        }

        ListNode node = new ListNode(key, value);
        nodeMap.put(key, node);
        listMap.putIfAbsent(1, new DoublyLinkedList());
        listMap.get(1).insertRight(node);
        lfuCount = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */