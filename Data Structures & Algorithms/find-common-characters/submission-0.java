class Solution {
    public List<String> commonChars(String[] words) {
        int[] globalCounts = new int[26];
        Arrays.fill(globalCounts, Integer.MAX_VALUE);

        for (String word : words) {
            int[] counts = new int[26];
            for (int i = 0; i < word.length(); i++) {
                counts[(int) (word.charAt(i) - 'a')]++;
            }
            
            for (int i = 0; i < 26; i++) {
                globalCounts[i] = Math.min(globalCounts[i], counts[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (globalCounts[i] > 0 && globalCounts[i] != Integer.MAX_VALUE) {
                res.add(Character.toString((char)(i + 'a')));
                globalCounts[i]--;
            }
        }
        return res;
    }
}