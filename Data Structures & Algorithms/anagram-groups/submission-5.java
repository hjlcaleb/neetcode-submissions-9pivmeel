class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordFreq = new HashMap<>();
        for(String str : strs) {
            int[] counts = new int[26];
            for (int j = 0; j < str.length(); j++) {
                counts[str.charAt(j) - 'a'] ++;
            }
            String countsDistribution = Arrays.toString(counts);
            wordFreq.putIfAbsent(countsDistribution, new ArrayList<>());
            wordFreq.get(countsDistribution).add(str);
        }
        return new ArrayList<>(wordFreq.values());
    }
}
