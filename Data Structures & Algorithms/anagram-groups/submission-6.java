class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] freq = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                freq[(int)(strs[i].charAt(j) - 'a')]++;
            }
            String id = Arrays.toString(freq);
            groups.computeIfAbsent(id, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(groups.values());
    }
}
