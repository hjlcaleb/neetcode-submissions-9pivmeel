class Node {
    private int key;
    private int val;
    private Node next;

    public Node(int key, int val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public Node() {
        key = -1;
        val = -1;
        next = null;
    }
}

class MyHashMap {
    private Node[] map;

    public MyHashMap() {
        map = new Node[1000];
        for (int i = 0; i < map.length; i++) {
            map[i] = new Node();
        }
    }
    
    public void put(int key, int value) {
        Node curr = map[hashKey(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new Node(key, value, null);
    }
    
    public int get(int key) {
        Node curr = map[hashKey(key)].next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node curr = map[hashKey(key)];
        while (curr != null && curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    private int hashKey(int key) {
        return key % map.length;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */