class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();

        for(String s : strs){
            int count[] = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a'] += 1;
            }

            String pattern = Arrays.toString(count);

            map.putIfAbsent(pattern, new ArrayList<>());
            map.get(pattern).add(s);
        }

        return new ArrayList<>(map.values());
        
    }
}
