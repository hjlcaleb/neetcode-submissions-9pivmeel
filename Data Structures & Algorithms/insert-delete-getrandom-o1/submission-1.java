class RandomizedSet {

    private Map<Integer, Integer> numMap;
    private List<Integer> nums;
    private Random rand;
    
    public RandomizedSet() {
        numMap = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (numMap.containsKey(val)) return false;
        numMap.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!numMap.containsKey(val)) return false;
        int lastVal = nums.get(nums.size() - 1);
        int index = numMap.get(val);
        nums.set(index, lastVal);
        numMap.put(lastVal, index);
        nums.remove(nums.size() - 1);
        numMap.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */