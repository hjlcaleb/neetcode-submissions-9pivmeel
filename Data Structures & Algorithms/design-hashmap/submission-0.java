class MyHashMap {
    private int[] hashmap;
    public MyHashMap() {
        hashmap = new int[1000001];
        Arrays.fill(hashmap, -1);
    }
    
    public void put(int key, int value) {
        hashmap[key] = value;
    }
    
    public int get(int key) {
        return hashmap[key];
    }
    
    public void remove(int key) {
        if (hashmap[key] != -1) {
            hashmap[key] = -1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */