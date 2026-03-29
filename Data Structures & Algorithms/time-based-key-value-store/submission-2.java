class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        if (map.get(key).containsKey(timestamp)) {
            return map.get(key).get(timestamp);
        }
        Integer targetTime = map.get(key).floorKey(timestamp);
        if (targetTime != null) {
            return map.get(key).get(targetTime);
        }
        return "";
    }
}
