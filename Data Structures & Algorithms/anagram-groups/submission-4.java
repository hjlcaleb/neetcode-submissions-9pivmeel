class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordFreq = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            int[] counts = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                counts[strs[i].charAt(j) - 'a'] ++;
            }
            String wordCount = Arrays.toString(counts);
            wordFreq.putIfAbsent(wordCount, new ArrayList<String>());
            wordFreq.get(wordCount).add(strs[i]);
        }
        return new ArrayList<>(wordFreq.values());
    }
}
