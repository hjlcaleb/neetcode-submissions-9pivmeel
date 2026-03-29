class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String sortedString = new String(word);

            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
                map.get(sortedString).add(strs[i]);
            } else {
                map.get(sortedString).add(strs[i]);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(String s : map.keySet()){
            result.add(map.get(s));
        }
        return result;
        
    }
}
