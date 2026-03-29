class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], 1);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(new int[] {entry.getValue(), entry.getKey()});
        }
        
        list.sort((a, b) -> b[0] - a[0]);

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = list.get(i)[1];
        }

        return result;

        
    }
}
