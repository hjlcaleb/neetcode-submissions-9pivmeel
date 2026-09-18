class MyHashSet {
    private Node[] set;
    public MyHashSet() {
        set = new Node[10000];
        for (int i = 0; i < 10000; i++) {
            set[i] = new Node(-1);
        }
    }
    
    public void add(int key) {
        int index = key % set.length;
        Node cur = set[index];
        while (cur.next != null) {
            if (cur.next.key == key) return;
            cur = cur.next;
        }

        cur.next = new Node(key);
    }
    
    public void remove(int key) {
        int index = key % set.length;
        Node cur = set[index];
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        int index = key % set.length;
        Node cur = set[index];
        while (cur.next != null) {
            if (cur.next.key == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private class Node {
        int key;
        Node next;

        public Node(int val) {
            this.key = val;
            this.next = null;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */